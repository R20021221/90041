package warehouse;

import employee.ShiftSummary;
import java.util.Scanner;

/**
 * Represents a multi-floor warehouse grid navigated by per-floor forklifts.
 */
public class WarehouseMap {

    private final int floors;
    private final int rows;
    private final int cols;

    private final WarehouseCell[][][] grid;
    private final Forklift[] forklifts;

    private boolean[][][] visitedShelves;
    private boolean shiftStarted;

    /**
     * Constructs a new WarehouseMap.
     *
     * @param floors number of floors
     * @param rows number of rows per floor
     * @param cols number of columns per floor
     */
    public WarehouseMap(int floors, int rows, int cols) {
        this.floors = floors;
        this.rows = rows;
        this.cols = cols;
        this.grid = new WarehouseCell[floors][rows][cols];
        this.forklifts = new Forklift[floors];

        this.visitedShelves = new boolean[floors][rows][cols];
        this.shiftStarted = false;

        initialiseGrid();
        initialiseForklifts();
    }

    /**
     * Displays the warehouse grid and forklift position.
     *
     * @param forklift forklift
     */
    public void display(Forklift forklift) {
        int floorIndex = findForkliftFloor(forklift);
        displayFloorBody(floorIndex);
    }

    /**
     * Displays every floor with its own forklift position.
     */

    public void displayAllFloors() {
        Messages.printLegend();
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            displayFloor(floorIndex);
        }
    }

    private void displayFloor(int floorIndex) {
        System.out.println();
        Messages.printFloorHeader(floorIndex + 1);
        System.out.println();
        displayFloorBody(floorIndex);
    }

    private void displayFloorBody(int floorIndex) {
        Forklift forklift = this.forklifts[floorIndex];
        System.out.println("Forklift at: (" + forklift.getRow() + "," + forklift.getCol() + ")");
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (forklift != null && r == forklift.getRow() && c == forklift.getCol()) {
                    System.out.print(Constants.FORKLIFT_SYMBOL + " ");
                } else {
                    System.out.print(Constants.getSymbol(this.grid[floorIndex][r][c].getType()) + " ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Starts a warehouse shift or continues the shared shift state.
     *
     * @param scanner scanner for input
     * @param shiftSummary current employee's shift summary
     */
    public void startShift(Scanner scanner, ShiftSummary shiftSummary) {
        if (isWarehouseComplete()) {
            printWarehouseCompleteForMenu();
            return;
        }

        this.shiftStarted = true;
        runFloorSelection(scanner, shiftSummary);
    }

    /**
     * Resumes an already started warehouse shift.
     *
     * @param scanner scanner for input
     * @param shiftSummary current employee's shift summary
     */
    public void resumeShift(Scanner scanner, ShiftSummary shiftSummary) {
        if (isWarehouseComplete()) {
            printWarehouseCompleteForMenu();
            return;
        }

        if (!this.shiftStarted) {
            System.out.println(Messages.NO_SHIFT_TO_RESUME);
            return;
        }

        runFloorSelection(scanner, shiftSummary);
    }

    /**
     * Runs the floor-selection loop before entering a movement menu.
     *
     * @param scanner scanner for console input
     * @param shiftSummary current employee's shift summary
     */
    private void runFloorSelection(Scanner scanner, ShiftSummary shiftSummary) {
        boolean inFloorMenu = true;
        while (inFloorMenu) {
            displayAllFloors();
            System.out.print(Messages.FLOOR_SELECTION_PROMPT);
            String input = readInputToken(scanner);

            if (Constants.MENU_RETURN.equalsIgnoreCase(input)) {
                System.out.println();
                return;
            }

            int floorIndex = parseFloorSelection(input);
            if (floorIndex < 0) {
                System.out.println();
                System.out.println("Invalid Input");
                continue;
            }

            Forklift forklift = this.forklifts[floorIndex];
            runMovementMenu(scanner, forklift, shiftSummary);
            if (isWarehouseComplete()) {
                return;
            }
        }
    }

    /**
     * Parses a one-based floor number entered by the user.
     *
     * @param input user input
     * @return zero-based floor index, or -1 when invalid
     */
    private int parseFloorSelection(String input) {
        try {
            int floorNumber = Integer.parseInt(input);
            if (floorNumber < 1 || floorNumber > this.floors) {
                return -1;
            }
            return floorNumber - 1;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    /**
     * Runs the movement loop for one selected floor.
     *
     * @param scanner scanner for console input
     * @param forklift forklift assigned to the selected floor
     * @param shiftSummary current employee's shift summary
     */
    private void runMovementMenu(Scanner scanner, Forklift forklift, ShiftSummary shiftSummary) {
        display(forklift);

        boolean shiftOver = false;
        while (!shiftOver) {

            if (isWarehouseComplete()) {
                printWarehouseCompleteForMenu();
                return;
            }

            Messages.printMovementOptions();
            String input = readInputToken(scanner).toUpperCase();

            // Quit to main menu
            if (Constants.MENU_QUIT.equals(input)) {
                forklift.setSessionPaused(true);
                System.out.println(Messages.SESSION_PAUSED);
                return;
            }

            // Deliver carried item at START (Rule A) - NOT a movement
            if (Constants.MOVE_DELIVER.equals(input)) {
                boolean delivered = deliverAtStart(forklift);
                if (delivered) {
                    shiftSummary.recordDeliveredItem();
                    int floorIndex = findForkliftFloor(forklift);
                    boolean floorComplete = isFloorComplete(floorIndex);
                    boolean warehouseComplete = isWarehouseComplete();
                    if (floorComplete) {
                        System.out.println(Messages.FLOOR_COMPLETE);
                    }
                    if (warehouseComplete) {
                        printWarehouseCompleteForMenu();
                        return;
                    }
                    if (floorComplete) {
                        return;
                    }
                }
                display(forklift);
                continue;
            }

            // Otherwise treat input as a movement direction
            boolean moved = forklift.move(input, getGridSnapshot(findForkliftFloor(forklift)));

            if (moved) {
                handleVisit(scanner, forklift);
            } else {
                printHitMessageFromAttempt(input, forklift, shiftSummary);
            }

            display(forklift);
        }
    }

    /**
     * Returns a snapshot of one floor's grid types.
     *
     * @param floorIndex zero-based floor index
     * @return snapshot of CellType values
     */
    public CellType[][] getGridSnapshot(int floorIndex) {
        CellType[][] snapshot = new CellType[this.rows][this.cols];
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                snapshot[r][c] = this.grid[floorIndex][r][c].getType();
            }
        }
        return snapshot;
    }

    /* ================= PUBLIC SUPPORT METHODS ================= */

    /**
     * Handles the interaction after a forklift moves onto an actionable cell.
     *
     * @param scanner scanner for shelf-menu input
     * @param forklift forklift that moved
     */
    public void handleVisit(Scanner scanner, Forklift forklift) {
        int floorIndex = findForkliftFloor(forklift);
        WarehouseCell current = this.grid[floorIndex][forklift.getRow()][forklift.getCol()];

        if (current.getType() == CellType.SHELF) {
            display(forklift);
            this.visitedShelves[floorIndex][current.getRow()][current.getCol()] = true;
            runShelfMenu(scanner, forklift, current);
        }
    }

    /* ================= PRIVATE METHODS ================= */

    /**
     * Checks whether a forklift is on the start cell.
     *
     * @param forklift forklift to check
     * @return true if the forklift is at START
     */
    private boolean isForkliftAtStart(Forklift forklift) {
        return forklift.getRow() == Constants.START_ROW && forklift.getCol() == Constants.START_COL;
    }

    /**
     * Prints the warehouse completion message with the menu-return spacing.
     */
    private void printWarehouseCompleteForMenu() {
        System.out.println(Messages.SHIFT_COMPLETE);
        System.out.println();
    }

    /**
     * Rule A delivery: you can ONLY deliver when standing on START (O).
     * Delivered item is removed from the game (not placed back on any shelf).
     */
    private boolean deliverAtStart(Forklift forklift) {
        if (!forklift.isCarrying()) {
            System.out.println(Messages.NOT_CARRYING);
            return false;
        }

        if (!isForkliftAtStart(forklift)) {
            System.out.println("You must stand on the START cell (O) to deliver.");
            return false;
        }

        forklift.drop();

        System.out.println("Item delivered successfully.");
        return true;
    }

    /**
     * Creates the base grid for all floors.
     */
    private void initialiseGrid() {
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c < this.cols; c++) {
                    CellType type = determineBaseCellType(r, c);
                    this.grid[floorIndex][r][c] = new WarehouseCell(r, c, type);
                }
            }
        }
    }

    /**
     * Creates one forklift for each floor.
     */
    private void initialiseForklifts() {
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            this.forklifts[floorIndex] = new Forklift();
        }
    }

    /**
     * Determines the default cell type for a location before CSV loading.
     *
     * @param row row index
     * @param col column index
     * @return default cell type
     */
    private CellType determineBaseCellType(int row, int col) {
        if (isBoundary(row, col)) {
            return CellType.WALL;
        }
        if (row == Constants.START_ROW && col == Constants.START_COL) {
            return CellType.START;
        }
        return CellType.AISLE;
    }

    /**
     * Checks whether a location is on the boundary wall.
     *
     * @param row row index
     * @param col column index
     * @return true if the location is on the map boundary
     */
    private boolean isBoundary(int row, int col) {
        return row == 0 || col == 0 || row == this.rows - 1 || col == this.cols - 1;
    }

    /**
     * Checks whether a zero-based floor index is inside this warehouse.
     *
     * @param floorIndex zero-based floor index
     * @return true if the floor exists
     */
    public boolean isValidFloorIndex(int floorIndex) {
        return floorIndex >= 0 && floorIndex < this.floors;
    }

    /**
     * Checks whether a row and column identify a non-boundary cell.
     *
     * @param row row index
     * @param col column index
     * @return true if the location is inside the usable warehouse area
     */
    public boolean isInteriorLocation(int row, int col) {
        return row > 0 && row < this.rows - 1 && col > 0 && col < this.cols - 1;
    }

    /**
     * Returns the cell type at a warehouse location.
     *
     * @param floorIndex zero-based floor index
     * @param row row index
     * @param col column index
     * @return cell type
     */
    public CellType getCellType(int floorIndex, int row, int col) {
        return this.grid[floorIndex][row][col].getType();
    }

    /**
     * Returns the shelf type at a warehouse location.
     *
     * @param floorIndex zero-based floor index
     * @param row row index
     * @param col column index
     * @return shelf type, or null if the cell has no shelf
     */
    public ShelfType getShelfType(int floorIndex, int row, int col) {
        return this.grid[floorIndex][row][col].getShelfType();
    }

    /**
     * Marks a warehouse location as restricted.
     *
     * @param floorIndex zero-based floor index
     * @param row row index
     * @param col column index
     */
    public void setRestrictedCell(int floorIndex, int row, int col) {
        this.grid[floorIndex][row][col].setType(CellType.RESTRICTED);
    }

    /**
     * Marks a warehouse location as a shelf and optionally adds an item.
     *
     * @param floorIndex zero-based floor index
     * @param row row index
     * @param col column index
     * @param shelfType shelf category
     * @param itemName item name, or blank when the shelf starts empty
     */
    public void setShelfCell(int floorIndex, int row, int col, ShelfType shelfType, String itemName) {
        WarehouseCell cell = this.grid[floorIndex][row][col];
        if (cell.getType() != CellType.SHELF) {
            cell.attachNewShelf(shelfType);
        }

        if (itemName != null && !itemName.trim().isEmpty()) {
            cell.addItemtoShelf(new Item(itemName.trim()));
        }
    }

    // RULE A completion: visited all shelves AND removed all items from all shelves AND no forklift is carrying.
    /**
     * Checks the assignment completion rule for the whole warehouse.
     *
     * @return true if all shelves are visited and empty and no forklift carries an item
     */
    private boolean isWarehouseComplete() {
        return allShelvesVisited()
                && allShelvesEmpty()
                && allForkliftsEmpty();
    }

    /**
     * Checks whether every forklift is empty.
     *
     * @return true if no forklift is carrying an item
     */
    private boolean allForkliftsEmpty() {
        for (Forklift forklift : this.forklifts) {
            if (forklift != null && forklift.isCarrying()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether every shelf has been visited.
     *
     * @return true if all shelves have been visited
     */
    private boolean allShelvesVisited() {
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c < this.cols; c++) {
                    if (this.grid[floorIndex][r][c].getType() == CellType.SHELF
                            && !this.visitedShelves[floorIndex][r][c]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks whether one floor has all shelves visited and empty.
     *
     * @param floorIndex zero-based floor index
     * @return true if the floor is complete
     */
    private boolean isFloorComplete(int floorIndex) {
        Forklift forklift = this.forklifts[floorIndex];
        if (forklift != null && forklift.isCarrying()) {
            return false;
        }
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (this.grid[floorIndex][r][c].getType() != CellType.SHELF) {
                    continue;
                }
                if (!this.visitedShelves[floorIndex][r][c]) {
                    return false;
                }
                Shelf shelf = this.grid[floorIndex][r][c].getShelf();
                if (shelf != null && shelf.getSize() > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks whether every shelf in the warehouse is empty.
     *
     * @return true if all shelves are empty
     */
    private boolean allShelvesEmpty() {
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c < this.cols; c++) {
                    if (this.grid[floorIndex][r][c].getType() == CellType.SHELF) {
                        Shelf shelf = this.grid[floorIndex][r][c].getShelf();
                        if (shelf != null && shelf.getSize() > 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Runs the shelf interaction menu for the current cell.
     *
     * @param scanner scanner for console input
     * @param forklift forklift on the shelf cell
     * @param cell shelf cell
     */
    private void runShelfMenu(Scanner scanner, Forklift forklift, WarehouseCell cell) {
        boolean inShelfMenu = true;
        while (inShelfMenu) {
            Messages.printShelfMenu();
            String input = readInputToken(scanner).toUpperCase();
            inShelfMenu = handleShelfMenuInput(scanner, forklift, cell, input);
        }
    }

    /**
     * Handles one shelf-menu command.
     *
     * @param scanner scanner for console input
     * @param forklift forklift on the shelf cell
     * @param cell shelf cell
     * @param input shelf-menu command
     * @return true to keep showing the shelf menu
     */
    private boolean handleShelfMenuInput(Scanner scanner, Forklift forklift, WarehouseCell cell, String input) {
        switch (input) {
            case Constants.SHELF_MENU_VIEW:
                printShelfItems(cell);
                return true;

            case Constants.SHELF_MENU_PICK:
                pickItemFromShelf(scanner, forklift, cell);
                return true;

            case Constants.SHELF_MENU_QUIT:
                return false;

            default:
                System.out.println(Messages.INVALID_INPUT);
                return true;
        }
    }

    /**
     * Prints the items currently stored on a shelf cell.
     *
     * @param cell shelf cell
     */
    private void printShelfItems(WarehouseCell cell) {
        Shelf shelf = cell.getShelf();
        if (shelf == null || shelf.getSize() == 0) {
            System.out.println(Messages.NO_ITEMS_ON_SHELF);
            return;
        }

        Item[] items = shelf.getItemsSnapshot();
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null && items[i].getName() != null) {
                System.out.printf("%d. %s%n", i + 1, items[i].getName());
            }
        }
    }

    /**
     * Handles picking one item from a shelf onto the forklift.
     *
     * @param scanner scanner for console input
     * @param forklift forklift on the shelf cell
     * @param cell shelf cell
     */
    private void pickItemFromShelf(Scanner scanner, Forklift forklift, WarehouseCell cell) {
        if (forklift.isCarrying()) {
            System.out.println(Messages.ALREADY_CARRYING);
            return;
        }

        Shelf shelf = cell.getShelf();
        if (shelf == null || shelf.getSize() == 0) {
            System.out.println(Messages.NO_ITEMS_ON_SHELF);
            return;
        }

        System.out.print(Messages.ENTER_ITEM_INDEX);
        String input = readInputToken(scanner);

        int index = parsePositiveInt(input);
        if (index < 1) {
            System.out.println(Messages.INVALID_INPUT);
            return;
        }

        Item removed = cell.removeItemfromShelf(index);
        if (removed == null) {
            System.out.println(Messages.INVALID_INPUT);
            return;
        }

        forklift.pickUp(removed);

        System.out.println(Messages.ITEM_PICKED);
    }

    /**
     * Parses a positive integer command value.
     *
     * @param value input text
     * @return parsed positive integer, or -1 when invalid
     */
    private int parsePositiveInt(String value) {
        try {
            int parsed = Integer.parseInt(value);
            return parsed > 0 ? parsed : -1;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    /**
     * Reads the next non-whitespace console token.
     *
     * @param scanner scanner for console input
     * @return trimmed input token
     */
    private String readInputToken(Scanner scanner) {
        return scanner.next().trim();
    }

    /**
     * Prints the correct blocked-movement message and updates the employee summary.
     *
     * @param direction attempted movement direction
     * @param forklift forklift that attempted the move
     * @param shiftSummary current employee's shift summary
     */
    private void printHitMessageFromAttempt(String direction, Forklift forklift, ShiftSummary shiftSummary) {
        int floorIndex = findForkliftFloor(forklift);
        int nextRow = forklift.getRow();
        int nextCol = forklift.getCol();

        if (Constants.MOVE_UP.equals(direction)) nextRow--;
        else if (Constants.MOVE_DOWN.equals(direction)) nextRow++;
        else if (Constants.MOVE_LEFT.equals(direction)) nextCol--;
        else if (Constants.MOVE_RIGHT.equals(direction)) nextCol++;
        else {
            System.out.println(Messages.INVALID_INPUT);
            return;
        }

        CellType type = this.grid[floorIndex][nextRow][nextCol].getType();
        if (type == CellType.RESTRICTED) {
            shiftSummary.recordRestrictedAreaHit();
            System.out.println(Messages.HIT_RESTRICTED);
            return;
        }

        shiftSummary.recordWallHit();
        System.out.println(Messages.HIT_WALL);
    }

    /**
     * Returns the forklift assigned to a floor.
     *
     * @param floorIndex zero-based floor index
     * @return floor forklift
     */
    public Forklift getForklift(int floorIndex) {
        return this.forklifts[floorIndex];
    }

    /**
     * Finds the floor assigned to a forklift.
     *
     * @param forklift forklift to locate
     * @return zero-based floor index
     */
    private int findForkliftFloor(Forklift forklift) {
        for (int floorIndex = 0; floorIndex < this.floors; floorIndex++) {
            if (this.forklifts[floorIndex] == forklift) {
                return floorIndex;
            }
        }
        return 0;
    }
}
