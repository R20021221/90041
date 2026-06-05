/**
 * Student Name: Guancheng Rong
 * Student ID: 1856981
 * Student Email: guancheng.rong@student.unimelb.edu.au
 * AI Usage Declaration:
 * I used ChatGPT to help me understand Java packages, abstract classes,
 * and Javadoc rules. I also used it to analyse sections of my code,
 * identify potential weaknesses, and revise syntax errors before testing
 * the program with my full data. A full record of prompts and outputs is
 * available upon request.
 */

import IOExceptions.NotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import employee.Designation;
import employee.Employee;
import employee.ShiftSummary;
import employee.Supervisor;
import io.EmployeeCsvReader;
import io.PayslipCsvReader;
import io.PayslipCsvWriter;
import io.WarehouseCsvReader;
import payroll.Payslip;
import warehouse.Constants;
import warehouse.WarehouseMap;
import warehouse.Messages;

/**
 * Main engine for the Warehouse Manager console application.
 */
public class WarehouseManagerEngine {

    public static final Scanner SCANNER = new Scanner(System.in);

    private int floors;
    private int rows;
    private int cols;
    private String warehouseFilePath;
    private String employeesFilePath;
    private WarehouseMap warehouseMap;
    private ArrayList<Employee> employees;
    private ArrayList<Payslip> loadedPayslips;
    private boolean payslipFileExists;
    private boolean payslipsGeneratedThisSession;

    /**
     * Main method.
     *
     * @param args command line args to the program
     */
    public static void main(String[] args) {
        WarehouseManagerEngine engine = new WarehouseManagerEngine();
        if (!engine.validateArgs(args)) {
            return;
        }
        if (!engine.loadFiles(args)) {
            return;
        }

        Messages.printWelcomeA2();
        engine.runLoginLoop();
    }

    /**
     * Validates the command-line arguments.
     *
     * @param args command-line arguments
     * @return true if valid
     */
    private boolean validateArgs(String[] args) {
        if (args == null || args.length != Constants.NUM_OF_CMD_ARGS) {
            System.out.println(Messages.INVALID_ARGS_USAGE);
            return false;
        }

        int parsedFloors;
        int parsedRows;
        int parsedCols;
        try {
            parsedFloors = Integer.parseInt(args[0]);
            parsedRows = Integer.parseInt(args[1]);
            parsedCols = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
            System.out.println(Messages.INVALID_ARGS_INTEGER);
            return false;
        }

        if (parsedFloors < Constants.MIN_FLOORS || parsedFloors > Constants.MAX_FLOORS) {
            System.out.println(Messages.INVALID_ARGS_FLOORS);
            return false;
        }

        if (parsedRows < Constants.MIN_DIMENSION || parsedCols < Constants.MIN_DIMENSION) {
            System.out.println(Messages.INVALID_ARGS_DIMENSIONS);
            return false;
        }

        this.floors = parsedFloors;
        this.rows = parsedRows;
        this.cols = parsedCols;
        this.warehouseFilePath = args[3];
        this.employeesFilePath = args[4];

        return true;
    }

    /**
     * Checks that input files can be read.
     *
     * @param args command-line args
     * @return true if both files are readable
     */
    private boolean loadFiles(String[] args) {
        File warehouseFile = new File(this.warehouseFilePath);
        File employeesFile = new File(this.employeesFilePath);

        if (!warehouseFile.isFile() || !warehouseFile.canRead()
                || !employeesFile.isFile() || !employeesFile.canRead()) {
            System.out.println(Messages.FILE_PROCESSING_ERROR);
            return false;
        }

        this.warehouseMap = new WarehouseMap(this.floors, this.rows, this.cols);

        System.out.println("Processing Warehouse file: " + this.warehouseFilePath);
        try {
            WarehouseCsvReader warehouseCsvReader = new WarehouseCsvReader();
            warehouseCsvReader.loadWarehouse(this.warehouseFilePath, this.warehouseMap);
        } catch (IOException ex) {
            System.out.println(Messages.FILE_PROCESSING_ERROR);
            return false;
        }

        System.out.println("Processing Employees file: " + this.employeesFilePath);
        try {
            EmployeeCsvReader employeeCsvReader = new EmployeeCsvReader();
            this.employees = employeeCsvReader.loadEmployees(this.employeesFilePath);
        } catch (IOException ex) {
            System.out.println(Messages.FILE_PROCESSING_ERROR);
            return false;
        }

        System.out.println("Processing Payslips file: " + Constants.PAYSLIPS_FILE_PATH);
        this.payslipFileExists = new File(Constants.PAYSLIPS_FILE_PATH).exists();
        try {
            PayslipCsvReader payslipCsvReader = new PayslipCsvReader();
            this.loadedPayslips = payslipCsvReader.loadPayslips(Constants.PAYSLIPS_FILE_PATH);
        } catch (IOException ex) {
            System.out.println(Messages.FILE_PROCESSING_ERROR);
            return false;
        }

        return true;
    }

    /**
     * Runs the employee login loop until the user terminates the program.
     */
    private void runLoginLoop() {
        boolean terminated = false;
        while (!terminated) {
            Messages.printEmployeeLoginPrompt();
            String employeeId = readInputToken();

            if (Constants.MENU_RETURN.equalsIgnoreCase(employeeId)) {
                exitProgram();
                terminated = true;
                continue;
            }

            try {
                Employee employee = findEmployeeById(employeeId);
                System.out.println();
                Messages.printEmployeeWelcome(employee.getEmployeeName(), employee.getDesignation().name());
                System.out.println();
                runRoleMenu(employee);
            } catch (NotFoundException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
        }
    }

    /**
     * Finds an employee by ID.
     *
     * @param employeeId employee ID entered by the user
     * @return matching employee
     * @throws NotFoundException if no employee has the supplied ID
     */
    private Employee findEmployeeById(String employeeId) throws NotFoundException {
        for (Employee employee : this.employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        throw new NotFoundException(Messages.EMPLOYEE_NOT_FOUND);
    }

    /**
     * Dispatches an employee to the menu for their designation.
     *
     * @param employee logged-in employee
     */
    private void runRoleMenu(Employee employee) {
        switch (employee.getDesignation()) {
            case OPERATOR:
            case SENIOR_OPERATOR:
                runOperatorMenu(employee);
                break;
            case SUPERVISOR:
                runSupervisorMenu(employee);
                break;
            case PAYROLL_MANAGER:
                runPayrollManagerMenu(employee);
                break;
            default:
                System.out.println(Messages.INVALID_INPUT);
        }
    }

    /**
     * Runs the operator and senior operator menu.
     *
     * @param employee logged-in operator-like employee
     */
    private void runOperatorMenu(Employee employee) {
        boolean logout = false;
        while (!logout) {
            Messages.printOperatorMenu(employee.getEmployeeName(), employee.getDesignation().name());
            String choice = readInputToken();

            switch (choice) {
                case Constants.MENU_START_SHIFT:
                    this.warehouseMap.startShift(SCANNER, employee.getShiftSummary());
                    break;
                case Constants.MENU_RESUME_SHIFT:
                    this.warehouseMap.resumeShift(SCANNER, employee.getShiftSummary());
                    break;
                case Constants.MENU_VIEW_SUMMARY:
                    Messages.printShiftSummary(employee.getShiftSummary());
                    System.out.println();
                    break;
                case Constants.MENU_VIEW_PAYSLIP:
                    viewEmployeePayslip(employee);
                    System.out.println();
                    break;
                case Constants.MENU_EXIT:
                    logout = true;
                    break;
                default:
                    System.out.println(Messages.INVALID_INPUT);
            }
        }
    }

    /**
     * Runs the supervisor menu.
     *
     * @param employee logged-in supervisor
     */
    private void runSupervisorMenu(Employee employee) {
        boolean logout = false;
        while (!logout) {
            Messages.printSupervisorMenu(employee.getEmployeeName());
            String choice = readInputToken();

            switch (choice) {
                case Constants.MENU_START_SHIFT:
                    this.warehouseMap.startShift(SCANNER, employee.getShiftSummary());
                    break;
                case Constants.MENU_RESUME_SHIFT:
                    this.warehouseMap.resumeShift(SCANNER, employee.getShiftSummary());
                    break;
                case Constants.MENU_VIEW_SUMMARY:
                    Messages.printShiftSummary(employee.getShiftSummary());
                    System.out.println();
                    break;
                case Constants.MENU_VIEW_PAYSLIP:
                    viewEmployeePayslip(employee);
                    System.out.println();
                    break;
                case Constants.MENU_SUPERVISOR_REPORTEES:
                    viewReporteeSummaries(employee);
                    break;
                case Constants.MENU_SUPERVISOR_LOGOUT:
                    logout = true;
                    break;
                default:
                    System.out.println(Messages.INVALID_INPUT);
            }
        }
    }

    /**
     * Runs the payroll manager menu.
     *
     * @param employee logged-in payroll manager
     */
    private void runPayrollManagerMenu(Employee employee) {
        boolean logout = false;
        while (!logout) {
            Messages.printPayrollManagerMenu(employee.getEmployeeName());
            String choice = readInputToken();

            switch (choice) {
                case Constants.MENU_START_SHIFT:
                    viewAllEmployeeSummaries();
                    break;
                case Constants.MENU_PAYROLL_GENERATE:
                    generatePayslips();
                    break;
                case Constants.MENU_PAYROLL_VIEW_PAYSLIPS:
                    viewAllPayslips();
                    break;
                case Constants.MENU_PAYROLL_LOGOUT:
                    logout = true;
                    break;
                default:
                    System.out.println(Messages.INVALID_INPUT);
            }
        }
    }

    /**
     * Generates current-session payslips for all employees in employees-file order.
     */
    private void generatePayslips() {
        ArrayList<Payslip> generatedPayslips = new ArrayList<>();
        for (Employee employee : this.employees) {
            generatedPayslips.add(createPayslip(employee));
        }

        this.loadedPayslips = generatedPayslips;
        this.payslipsGeneratedThisSession = true;
        System.out.println(Messages.PAYSLIPS_GENERATED_SUCCESSFULLY);
        System.out.println();
    }

    /**
     * Prints shift summaries for a supervisor's direct reportees.
     *
     * @param employee logged-in supervisor
     */
    private void viewReporteeSummaries(Employee employee) {
        if (!(employee instanceof Supervisor)) {
            System.out.println(Messages.MENU_UNAVAILABLE);
            return;
        }

        Supervisor supervisor = (Supervisor) employee;
        ArrayList<Employee> reportees = supervisor.getReportees();
        System.out.println();
        for (Employee reportee : reportees) {
            Messages.printEmployeeShiftSummary(reportee);
            System.out.println();
        }
    }

    /**
     * Prints shift summaries for all employees in employees-file order.
     */
    private void viewAllEmployeeSummaries() {
        System.out.println();
        for (Employee employee : this.employees) {
            Messages.printEmployeeShiftSummary(employee);
            System.out.println();
        }
    }

    /**
     * Calculates one payslip from an employee's current-session shift summary.
     *
     * @param employee employee whose payslip should be created
     * @return calculated payslip
     */
    private Payslip createPayslip(Employee employee) {
        double basePay = employee.getBaseSalary();
        double deliveredItemPay = 0.0;
        double hitsPenalty = 0.0;
        double restrictedAreaPenalty = 0.0;
        double reporteesManagingPay = 0.0;

        if (employee.getDesignation() != Designation.PAYROLL_MANAGER) {
            ShiftSummary summary = employee.getShiftSummary();
            deliveredItemPay = summary.getDeliveredItemCount() * Constants.DELIVERY_PAY;
            hitsPenalty = summary.getWallHitCount() * Constants.HITS_PENALTY;
            restrictedAreaPenalty = summary.getRestrictedAreaHitCount() * Constants.RESTRICTED_AREA_PENALTY;
        }

        if (employee instanceof Supervisor) {
            Supervisor supervisor = (Supervisor) employee;
            reporteesManagingPay = supervisor.getReportees().size() * Constants.REPORTEE_MANAGEMENT_PAY;
        }

        double netSalary = basePay + deliveredItemPay - hitsPenalty
                - restrictedAreaPenalty + reporteesManagingPay;

        return new Payslip(employee.getEmployeeId(), employee.getEmployeeName(), basePay,
                deliveredItemPay, hitsPenalty, restrictedAreaPenalty,
                reporteesManagingPay, netSalary);
    }

    /**
     * Prints one employee's payslip when it is available.
     *
     * @param employee employee requesting their payslip
     */
    private void viewEmployeePayslip(Employee employee) {
        try {
            if (!this.payslipsGeneratedThisSession && !this.payslipFileExists) {
                throw new NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
            }

            Payslip payslip = findPayslipByEmployeeId(employee.getEmployeeId());
            Messages.printPayslip(payslip);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Prints all payslips that belong to employees loaded in the current run.
     */
    private void viewAllPayslips() {
        try {
            if (!this.payslipsGeneratedThisSession && !this.payslipFileExists) {
                throw new NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
            }

            ArrayList<Payslip> currentEmployeePayslips = getPayslipsForCurrentEmployees();
            if (currentEmployeePayslips.isEmpty()) {
                throw new NotFoundException(Messages.PAYSLIP_NOT_GENERATED_YET);
            }

            System.out.println();
            for (Payslip payslip : currentEmployeePayslips) {
                Messages.printPayslip(payslip);
                System.out.println(Messages.PAYSLIP_SEPARATOR);
                System.out.println();
            }
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Finds a payslip by employee ID.
     *
     * @param employeeId employee ID to search for
     * @return matching payslip
     * @throws NotFoundException if no payslip exists for the supplied employee ID
     */
    private Payslip findPayslipByEmployeeId(String employeeId) throws NotFoundException {
        if (this.loadedPayslips == null) {
            throw new NotFoundException(Messages.payslipNotFoundMessage(employeeId));
        }

        for (Payslip payslip : this.loadedPayslips) {
            if (payslip.getEmployeeId().equals(employeeId)) {
                return payslip;
            }
        }

        throw new NotFoundException(Messages.payslipNotFoundMessage(employeeId));
    }

    /**
     * Returns payslips whose employee IDs exist in the current employees file.
     *
     * @return filtered payslips
     */
    private ArrayList<Payslip> getPayslipsForCurrentEmployees() {
        ArrayList<Payslip> currentEmployeePayslips = new ArrayList<>();
        if (this.loadedPayslips == null) {
            return currentEmployeePayslips;
        }

        for (Payslip payslip : this.loadedPayslips) {
            if (employeeExists(payslip.getEmployeeId())) {
                currentEmployeePayslips.add(payslip);
            }
        }
        return currentEmployeePayslips;
    }

    /**
     * Checks whether an employee ID exists in the current employees list.
     *
     * @param employeeId employee ID to search for
     * @return true if the employee exists
     */
    private boolean employeeExists(String employeeId) {
        for (Employee employee : this.employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves payslip data when required and prints the final goodbye message.
     */
    private void exitProgram(){
        if (this.payslipsGeneratedThisSession) {
            System.out.println(Messages.SAVING_PAYSLIPS_FILE);
            try {
                PayslipCsvWriter payslipCsvWriter = new PayslipCsvWriter();
                payslipCsvWriter.writePayslips(Constants.PAYSLIPS_FILE_PATH, getPayslipsForCurrentEmployees());
            } catch (IOException ex) {
                System.out.println(Messages.FILE_PROCESSING_ERROR);
            }
        }
        else if (this.payslipFileExists) {
            System.out.println(Messages.SAVING_PAYSLIPS_FILE);
            try {
                PayslipCsvWriter payslipCsvWriter = new PayslipCsvWriter();
                payslipCsvWriter.writePayslips(Constants.PAYSLIPS_FILE_PATH, getPayslipsForCurrentEmployees());
            } catch (IOException ex) {
                System.out.println(Messages.FILE_PROCESSING_ERROR);
            }
        }
        else {
            System.out.println(Messages.NO_PAYSLIPS_TO_SAVE);
        }
        System.out.println(Messages.GOODBYE_A2);
    }

    /**
     * Reads the next non-whitespace console token.
     *
     * @return trimmed input token
     */
    private String readInputToken() {
        return SCANNER.next().trim();
    }

}
