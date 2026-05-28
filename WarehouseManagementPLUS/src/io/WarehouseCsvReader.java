package io;

import IOExceptions.InvalidLineException;
import IOExceptions.InvalidLocationException;
import IOExceptions.InvalidTypeException;
import IOExceptions.InvalidWarehouseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import warehouse.CellType;
import warehouse.ShelfType;
import warehouse.WarehouseMap;

/**
 * Reads warehouse CSV input and forwards valid rows to the warehouse model.
 */
public class WarehouseCsvReader {

    private static final int WAREHOUSE_FIELD_COUNT = 6;

    /**
     * Opens and scans a warehouse CSV file.
     *
     * @param filePath warehouse CSV path
     * @param warehouseMap warehouse model to populate in later phases
     * @return number of non-empty data rows with the expected field count
     * @throws FileNotFoundException if the file cannot be opened
     */
    public int loadWarehouse(String filePath, WarehouseMap warehouseMap) throws FileNotFoundException {
        int loadedRowCount = 0;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            int lineNumber = 0;
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                lineNumber++;
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(",");
                try {
                    if (fields.length != WAREHOUSE_FIELD_COUNT) {
                        throw new InvalidLineException(invalidWarehouseLineMessage(lineNumber));
                    }

                    if (loadWarehouseLine(fields, lineNumber, warehouseMap)) {
                        loadedRowCount++;
                    }
                } catch (InvalidLineException | InvalidLocationException
                         | InvalidTypeException | InvalidWarehouseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return loadedRowCount;
    }

    private boolean loadWarehouseLine(String[] fields, int lineNumber, WarehouseMap warehouseMap)
            throws InvalidLocationException, InvalidTypeException, InvalidWarehouseException {
        String floorValue = fields[0].trim();
        int floorNumber;
        try {
            floorNumber = Integer.parseInt(floorValue);
        } catch (NumberFormatException ex) {
            throw new InvalidTypeException(invalidWarehouseFloorMessage(lineNumber));
        }

        int floorIndex = floorNumber - 1;
        if (floorNumber <= 0 || !warehouseMap.isValidFloorIndex(floorIndex)) {
            throw new InvalidTypeException(invalidWarehouseFloorMessage(lineNumber));
        }

        int row;
        int col;
        try {
            row = Integer.parseInt(fields[1].trim());
            col = Integer.parseInt(fields[2].trim());
        } catch (NumberFormatException ex) {
            throw new InvalidLocationException(invalidWarehouseLocationMessage(lineNumber));
        }

        if (!warehouseMap.isInteriorLocation(row, col)) {
            throw new InvalidLocationException(invalidWarehouseLocationMessage(lineNumber));
        }

        String cellTypeValue = fields[3].trim();
        if (!CellType.RESTRICTED.name().equals(cellTypeValue) && !CellType.SHELF.name().equals(cellTypeValue)) {
            throw new InvalidTypeException(invalidWarehouseCellTypeMessage(lineNumber));
        }

        CellType incomingType = CellType.valueOf(cellTypeValue);
        if (incomingType == CellType.RESTRICTED && hasRestrictedShelfType(fields)) {
            throw new InvalidWarehouseException(restrictedShelfTypeMessage(lineNumber));
        }

        CellType currentType = warehouseMap.getCellType(floorIndex, row, col);
        if (currentType != CellType.AISLE && currentType != incomingType) {
            throw new InvalidWarehouseException(warehouseOverlapMessage(lineNumber));
        }

        if (incomingType == CellType.RESTRICTED) {
            return loadRestrictedLine(fields, lineNumber, warehouseMap, floorIndex, row, col);
        }

        return loadShelfLine(fields, lineNumber, warehouseMap, floorIndex, row, col);
    }

    private boolean hasRestrictedShelfType(String[] fields) {
        String shelfTypeValue = fields[4].trim();
        return !shelfTypeValue.isEmpty() && !"-".equals(shelfTypeValue);
    }

    private boolean loadRestrictedLine(String[] fields, int lineNumber, WarehouseMap warehouseMap,
                                       int floorIndex, int row, int col) throws InvalidWarehouseException {
        if (hasRestrictedShelfType(fields)) {
            throw new InvalidWarehouseException(restrictedShelfTypeMessage(lineNumber));
        }

        warehouseMap.setRestrictedCell(floorIndex, row, col);
        return true;
    }

    private boolean loadShelfLine(String[] fields, int lineNumber, WarehouseMap warehouseMap,
                                  int floorIndex, int row, int col)
            throws InvalidTypeException, InvalidWarehouseException {
        ShelfType shelfType;
        try {
            shelfType = ShelfType.valueOf(fields[4].trim());
        } catch (IllegalArgumentException ex) {
            throw new InvalidTypeException(invalidShelfTypeMessage(lineNumber));
        }

        ShelfType existingShelfType = warehouseMap.getShelfType(floorIndex, row, col);
        if (existingShelfType != null && existingShelfType != shelfType) {
            throw new InvalidWarehouseException(shelfTypeMismatchMessage(lineNumber));
        }

        warehouseMap.setShelfCell(floorIndex, row, col, shelfType, fields[5]);
        return true;
    }

    private String invalidWarehouseLineMessage(int lineNumber) {
        return "Invalid Warehouse line at line " + lineNumber + ". Skipping this line.";
    }

    private String invalidWarehouseFloorMessage(int lineNumber) {
        return "Invalid floor number in warehouse file: " + lineNumber + ". Skipping this line.";
    }

    private String invalidWarehouseLocationMessage(int lineNumber) {
        return "Invalid location in warehouse file at line " + lineNumber + ". Skipping this line.";
    }

    private String invalidWarehouseCellTypeMessage(int lineNumber) {
        return "Invalid cell type at line " + lineNumber + ". Skipping this line.";
    }

    private String warehouseOverlapMessage(int lineNumber) {
        return "Restricted location overlaps shelf at line " + lineNumber + ". Skipping this line.";
    }

    private String restrictedShelfTypeMessage(int lineNumber) {
        return "Shelf Type cannot be defined for Restricted Location at line "
                + lineNumber + ". Skipping this line.";
    }

    private String invalidShelfTypeMessage(int lineNumber) {
        return "Invalid shelf type at line " + lineNumber + ". Skipping this line.";
    }

    private String shelfTypeMismatchMessage(int lineNumber) {
        return "Shelf Type mismatched at line " + lineNumber + ". Skipping this line.";
    }
}
