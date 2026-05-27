package warehouse;

import employee.Employee;
import employee.ShiftSummary;
import payroll.Payslip;

/**
 * Class for user-facing messages.
 */
public final class Messages {

    private Messages() { }

    public static final String HYPHEN = "-";

    public static final String INVALID_ARGS_USAGE =
            "Invalid number of Command Line Arguments. Usage: java WarehouseManagerEngine <floors> <rows> <cols> <master file> <employees file>.";

    public static final String INVALID_ARGS_INTEGER =
            "Error: Floors, rows and columns must be integers.";

    public static final String INVALID_ARGS_FLOORS =
            "Error: Number of floors has to be between 1 and 3.";

    public static final String INVALID_ARGS_DIMENSIONS =
            "Error: Rows and columns must be at least 4 to allow proper map layout.";

    public static final String FILE_PROCESSING_ERROR =
            "Unable to process file. Exiting program.";

    public static final String SAVING_PAYSLIPS_FILE =
            "Saving Payslips file: data/payslips.csv";

    public static final String NO_PAYSLIPS_TO_SAVE =
            "No payslips to save.";
    
    public static final String GOODBYE_A2 =
        "Goodbye!";

    public static final String EMPLOYEE_NOT_FOUND =
            "Employee ID not found. Please try again.";

    public static final String MENU_UNAVAILABLE =
            "This option is not available yet.";

    public static final String FLOOR_SELECTION_PROMPT =
            "Enter a floor number to navigate the warehouse or X to return to the main menu : ";

    public static final String INVALID_INPUT =
            "Invalid input.";

    public static final String NO_SHIFT_TO_RESUME =
            "Shift not started, cannot resume shift.";

    public static final String GOODBYE =
            "Session abandoned. Goodbye!";

    public static final String SHIFT_COMPLETE =
            "All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.";

    public static final String SESSION_PAUSED =
            "Shift paused.";

    public static final String HIT_WALL =
            "You cannot enter that area.";

    public static final String HIT_RESTRICTED =
            "You cannot enter that area.";

    public static final String NO_ITEMS_ON_SHELF =
            "No items on this shelf.";

    public static final String NOT_CARRYING =
            "You are not carrying any item.";

    public static final String ALREADY_CARRYING =
            "You are already carrying an item. Place it before picking another.";

    public static final String ENTER_ITEM_INDEX =
            "Enter item number to pick (e.g., 1): ";

    public static final String ITEM_PICKED =
            "Item picked successfully.";

    public static final String ITEM_PLACED =
            "Item placed successfully.";

    public static final String RESET_DONE =
            "Shift and warehouse reset.";

    public static final String PAYSLIPS_GENERATED_SUCCESSFULLY =
            "Payslips generated successfully.";

    public static final String PAYSLIP_NOT_GENERATED_YET =
            "Payslip not generated yet.";

    public static final String PAYSLIP_SEPARATOR =
            "=======================";

    public static void printWelcome() {
        System.out.println("Welcome to Warehouse Manager Console.");
    }

    public static void printMainMenuCommands() {
        System.out.println("\n=== Warehouse Manager Menu ===");
        System.out.println("1. Start warehouse shift.");
        System.out.println("2. Resume last shift.");
        System.out.println("4. Reset shift and warehouse.");
        System.out.println("5. Abandon the shift and exit.");
        System.out.print("> ");
    }

    public static void printEmployeeLoginPrompt() {
        System.out.println();
        System.out.println("=== Employee Login ===");
        System.out.println("Enter your Employee ID or X to terminate: ");
    }

    public static void printEmployeeWelcome(String employeeName, String designation) {
        System.out.println("Welcome, " + employeeName + " [" + designation + "]");
    }

    public static void printOperatorMenu(String employeeName, String designation) {
        System.out.println("=== Operator Menu — " + employeeName + " [" + designation + "] ===");
        System.out.println("1. Start warehouse shift");
        System.out.println("2. Resume last shift");
        System.out.println("3. View my shift summary");
        System.out.println("4. View my payslip");
        System.out.println("5. Logout");
        System.out.print("> ");
    }

    public static void printSupervisorMenu(String employeeName) {
        System.out.println("=== Supervisor Menu — " + employeeName + " [SUPERVISOR] ===");
        System.out.println("1. Start warehouse shift");
        System.out.println("2. Resume last shift");
        System.out.println("3. View my shift summary");
        System.out.println("4. View my payslip");
        System.out.println("5. View all reportees' shift summary");
        System.out.println("6. Logout");
        System.out.print("> ");
    }

    public static void printPayrollManagerMenu(String employeeName) {
        System.out.println("=== Payroll Manager Menu — " + employeeName + " [PAYROLL_MANAGER] ===");
        System.out.println("1. View all employees' shift summary");
        System.out.println("2. Generate payslips");
        System.out.println("3. View all generated payslips");
        System.out.println("4. Logout");
        System.out.print("> ");
    }

    public static void printMovementOptions() {
        System.out.println("Enter direction:");
        System.out.println("U - Up.");
        System.out.println("D - Down.");
        System.out.println("L - Left.");
        System.out.println("R - Right.");
        System.out.println("T - Deliver carried item at START (O).");
        System.out.println("Q - Quit to main menu.");
        System.out.print("> ");
    }


    public static void printShelfMenu() {
        System.out.println("Shelf Menu:");
        System.out.println("Press V to view items.");
        System.out.println("Press P to pick an item.");
        System.out.println("Press Q to exit shelf menu.");
        System.out.print("> ");
    }

    public static void printLegend() {
        System.out.println("Legend: # Wall | . Aisle | X Restricted | S Shelf | O Start | F Forklift");
    }

    public static void printFloorHeader(int floorNumber) {
        System.out.println("==========Floor: " + floorNumber + "==========");
    }

    public static void printShiftSummary(ShiftSummary shiftSummary) {
        System.out.println("No. of Items delivered: " + shiftSummary.getDeliveredItemCount());
        System.out.println("No. of Walls hit: " + shiftSummary.getWallHitCount());
        System.out.println("No. of Restricted Areas hit: " + shiftSummary.getRestrictedAreaHitCount());
    }

    public static void printEmployeeShiftSummary(Employee employee) {
        System.out.println("Employee Id: " + employee.getEmployeeId()
                + ", Employee Name: " + employee.getEmployeeName()
                + ", Designation: " + employee.getDesignation().name());
        printShiftSummary(employee.getShiftSummary());
    }

    public static void printPayslip(Payslip payslip) {
        System.out.println("EmployeeID: " + payslip.getEmployeeId());
        System.out.println("Employee Name: " + payslip.getEmployeeName());
        System.out.println("Base salary: " + formatMoney(payslip.getBasePay()));
        System.out.println("Delivered Item Pay: " + formatMoney(payslip.getDeliveredItemPay()));
        System.out.println("Hits Penalty: " + formatMoney(payslip.getHitsPenalty()));
        System.out.println("Restricted Penalty: " + formatMoney(payslip.getRestrictedAreaPenalty()));
        System.out.println("Reportees Management Pay: " + formatMoney(payslip.getReporteesManagingPay()));
        System.out.println("Net Salary: " + formatMoney(payslip.getNetSalary()));
    }

    public static void printPayslipNotFound(String employeeId) {
        System.out.println(payslipNotFoundMessage(employeeId));
    }

    public static String payslipNotFoundMessage(String employeeId) {
        return "Employee " + employeeId + "'s payslip not found.";
    }

    private static String formatMoney(double value) {
        return String.format("%.2f", value);
    }

    public static void printInvalidWarehouseLine(int lineNumber) {
        System.out.println("Invalid Warehouse line at line " + lineNumber + ". Skipping this line.");
    }

    public static void printInvalidWarehouseFloor(String floorValue) {
        System.out.println("Invalid floor number in warehouse file: " + floorValue + ". Skipping this line.");
    }

    public static void printInvalidWarehouseLocation(int lineNumber) {
        System.out.println("Invalid location in warehouse file at line " + lineNumber + ". Skipping this line.");
    }

    public static void printInvalidWarehouseCellType(int lineNumber) {
        System.out.println("Invalid cell type at line " + lineNumber + ". Skipping this line.");
    }

    public static void printWarehouseOverlap(int lineNumber) {
        System.out.println("Restricted location overlaps shelf at line " + lineNumber + ". Skipping this line.");
    }

    public static void printRestrictedShelfType(int lineNumber) {
        System.out.println("Shelf Type cannot be defined for Restricted Location at line "
                + lineNumber + ". Skipping this line.");
    }

    public static void printInvalidShelfType(int lineNumber) {
        System.out.println("Invalid shelf type at line " + lineNumber + ". Skipping this line.");
    }

    public static void printShelfTypeMismatch(int lineNumber) {
        System.out.println("Shelf Type mismatched at line " + lineNumber + ". Skipping this line.");
    }

    public static void printIncorrectEmployeesLine(int lineNumber) {
        System.out.println("Incorrect Employees line at line " + lineNumber + ". Skipping this line.");
    }

    public static void printIncorrectEmployeeDetails(int lineNumber) {
        System.out.println("Incorrect Employee Details at line " + lineNumber + ". Skipping the line.");
    }

    public static void printIncorrectEmployeeDesignation(int lineNumber) {
        System.out.println("Incorrect Employee Designation at line " + lineNumber + ". Skipping this line.");
    }

    public static void printIncorrectPayslipsLine(int lineNumber) {
        System.out.println("Incorrect Payslips line at line " + lineNumber + ". Skipping this line.");
    }

    public static void printIncorrectPayslipEmployeeDetails(int lineNumber) {
        System.out.println("Incorrect Employee Details at line " + lineNumber + ". Skipping this line.");
    }

    public static void printIncorrectEmployeeSalaryDetails(int lineNumber) {
        System.out.println("Incorrect Employee Salary details at line " + lineNumber + ". Skipping this line.");
    }

    public static void printWelcomeA2() {
        System.out.println("Welcome to Warehouse Manager Assignment 2.");
    }
}
