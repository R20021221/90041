package io;

import IOExceptions.InvalidLineException;
import IOExceptions.InvalidTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import payroll.Payslip;

/**
 * Reads payslip CSV input from the fixed payslip file path.
 */
public class PayslipCsvReader {

    private static final int PAYSLIP_FIELD_COUNT = 8;

    /**
     * Opens and scans a payslip CSV file.
     *
     * @param filePath payslip CSV path
     * @return loaded payslips
     * @throws FileNotFoundException if the file cannot be opened
     */
    public ArrayList<Payslip> loadPayslips(String filePath) throws FileNotFoundException {
        ArrayList<Payslip> payslips = new ArrayList<>();
        File payslipFile = new File(filePath);
        if (!payslipFile.exists()) {
            System.out.println("Payslip file doesnt exist: " + filePath);
            return payslips;
        }

        try (Scanner scanner = new Scanner(payslipFile)) {
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

                String[] fields = line.split(",", -1);
                try {
                    Payslip payslip = parsePayslipLine(fields, lineNumber);
                    payslips.add(payslip);
                } catch (InvalidLineException | InvalidTypeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return payslips;
    }

    /**
     * Parses and validates one payslip CSV data line.
     *
     * @param fields comma-separated fields from the line
     * @param lineNumber source CSV line number
     * @return payslip created from the line
     * @throws InvalidLineException if required identity fields are invalid
     * @throws InvalidTypeException if salary fields are invalid
     */
    private Payslip parsePayslipLine(String[] fields, int lineNumber)
            throws InvalidLineException, InvalidTypeException {
        if (fields.length != PAYSLIP_FIELD_COUNT) {
            throw new InvalidLineException(incorrectPayslipsLineMessage(lineNumber));
        }

        String employeeId = fields[0].trim();
        String employeeName = fields[1].trim();
        if (employeeId.isEmpty() || employeeName.isEmpty()) {
            throw new InvalidLineException(incorrectPayslipEmployeeDetailsMessage(lineNumber));
        }

        double basePay = parseMoney(fields[2].trim());
        double deliveredItemPay = parseMoney(fields[3].trim());
        double hitsPenalty = parseMoney(fields[4].trim());
        double restrictedAreaPenalty = parseMoney(fields[5].trim());
        double reporteesManagingPay = parseMoney(fields[6].trim());
        double netSalary = parseMoney(fields[7].trim());

        if (basePay <= 0 || deliveredItemPay < 0 || hitsPenalty < 0
                || restrictedAreaPenalty < 0 || reporteesManagingPay < 0 || netSalary <= 0) {
            throw new InvalidTypeException(incorrectEmployeeSalaryDetailsMessage(lineNumber));
        }

        return new Payslip(employeeId, employeeName, basePay, deliveredItemPay, hitsPenalty,
                restrictedAreaPenalty, reporteesManagingPay, netSalary);
    }

    /**
     * Parses a finite money value.
     *
     * @param value money text from the CSV file
     * @return parsed money value, or -1 when invalid
     */
    private double parseMoney(String value) {
        try {
            double parsedMoney = Double.parseDouble(value);
            if (Double.isNaN(parsedMoney) || Double.isInfinite(parsedMoney)) {
                return -1;
            }
            return parsedMoney;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private String incorrectPayslipsLineMessage(int lineNumber) {
        return "Incorrect Payslips line at line " + lineNumber + ". Skipping this line.";
    }

    private String incorrectPayslipEmployeeDetailsMessage(int lineNumber) {
        return "Incorrect Employee Details at line " + lineNumber + ". Skipping this line.";
    }

    private String incorrectEmployeeSalaryDetailsMessage(int lineNumber) {
        return "Incorrect Employee Salary details at line " + lineNumber + ". Skipping this line.";
    }
}
