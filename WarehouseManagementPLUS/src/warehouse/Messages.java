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
            "Invalid number of Command Line Arguments. Usage: java WarehouseManagerEngine "
                    + "<floors> <rows> <cols> <master file> <employees file>.";

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

    public static final String SHIFT_COMPLETE =
            "All shelves in the warehouse are empty and nothing to deliver. Returning to main menu.";

    public static final String FLOOR_COMPLETE =
            "This floor has all shelves empty. Return to floor menu.";

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

    public static final String PAYSLIPS_GENERATED_SUCCESSFULLY =
            "Payslips generated successfully.";

    public static final String PAYSLIP_NOT_GENERATED_YET =
            "Payslip not generated yet.";

    public static final String PAYSLIP_SEPARATOR =
            "=======================";

    /**
     * Prints the employee login prompt.
     */
    public static void printEmployeeLoginPrompt() {
        System.out.println();
        System.out.println("=== Employee Login ===");
        System.out.print("Enter your Employee ID or X to terminate: ");
    }

    /**
     * Prints the welcome line for a successfully logged-in employee.
     *
     * @param employeeName employee name
     * @param designation employee designation
     */
    public static void printEmployeeWelcome(String employeeName, String designation) {
        System.out.println("Welcome, " + employeeName + " [" + designation + "]");
    }

    /**
     * Prints the operator or senior operator menu.
     *
     * @param employeeName employee name
     * @param designation employee designation
     */
    public static void printOperatorMenu(String employeeName, String designation) {
        System.out.println("=== Operator Menu — " + employeeName + " [" + designation + "] ===");
        System.out.println("1. Start warehouse shift");
        System.out.println("2. Resume last shift");
        System.out.println("3. View my shift summary");
        System.out.println("4. View my payslip");
        System.out.println("5. Logout");
        System.out.print("> ");
    }

    /**
     * Prints the supervisor menu.
     *
     * @param employeeName employee name
     */
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

    /**
     * Prints the payroll manager menu.
     *
     * @param employeeName employee name
     */
    public static void printPayrollManagerMenu(String employeeName) {
        System.out.println("=== Payroll Manager Menu — " + employeeName + " [PAYROLL_MANAGER] ===");
        System.out.println("1. View all employees' shift summary");
        System.out.println("2. Generate payslips");
        System.out.println("3. View all generated payslips");
        System.out.println("4. Logout");
        System.out.print("> ");
    }

    /**
     * Prints the movement menu used while navigating a warehouse floor.
     */
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


    /**
     * Prints the shelf interaction menu.
     */
    public static void printShelfMenu() {
        System.out.println("Shelf Menu:");
        System.out.println("Press V to view items.");
        System.out.println("Press P to pick an item.");
        System.out.println("Press Q to exit shelf menu.");
        System.out.print("> ");
    }

    /**
     * Prints the warehouse map legend.
     */
    public static void printLegend() {
        System.out.println("Legend: # Wall | . Aisle | X Restricted | S Shelf | O Start | F Forklift");
    }

    /**
     * Prints the heading for one floor.
     *
     * @param floorNumber one-based floor number
     */
    public static void printFloorHeader(int floorNumber) {
        System.out.println("==========Floor: " + floorNumber + "==========");
    }

    /**
     * Prints one employee's shift summary.
     *
     * @param shiftSummary shift summary to print
     */
    public static void printShiftSummary(ShiftSummary shiftSummary) {
        System.out.println("No. of Items delivered: " + shiftSummary.getDeliveredItemCount());
        System.out.println("No. of Walls hit: " + shiftSummary.getWallHitCount());
        System.out.println("No. of Restricted Areas hit: " + shiftSummary.getRestrictedAreaHitCount());
    }

    /**
     * Prints an employee identity line followed by that employee's shift summary.
     *
     * @param employee employee whose summary should be printed
     */
    public static void printEmployeeShiftSummary(Employee employee) {
        System.out.println("Employee Id: " + employee.getEmployeeId()
                + ", Employee Name: " + employee.getEmployeeName()
                + ", Designation: " + employee.getDesignation().name());
        printShiftSummary(employee.getShiftSummary());
    }

    /**
     * Prints a payslip in the required console format.
     *
     * @param payslip payslip to print
     */
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

    /**
     * Prints the standard missing-payslip message for one employee.
     *
     * @param employeeId employee ID
     */
    public static void printPayslipNotFound(String employeeId) {
        System.out.println(payslipNotFoundMessage(employeeId));
    }

    /**
     * Builds the standard missing-payslip message for one employee.
     *
     * @param employeeId employee ID
     * @return missing-payslip message
     */
    public static String payslipNotFoundMessage(String employeeId) {
        return "Employee " + employeeId + "'s payslip not found.";
    }

    private static String formatMoney(double value) {
        return String.format("%.2f", value);
    }

    /**
     * Prints the message for an invalid warehouse CSV line structure.
     *
     * @param lineNumber CSV line number
     */
    public static void printInvalidWarehouseLine(int lineNumber) {
        System.out.println("Invalid Warehouse line at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for an invalid warehouse floor value.
     *
     * @param floorValue invalid floor value
     */
    public static void printInvalidWarehouseFloor(String floorValue) {
        System.out.println("Invalid floor number in warehouse file: " + floorValue + ". Skipping this line.");
    }

    /**
     * Prints the message for an invalid warehouse row or column location.
     *
     * @param lineNumber CSV line number
     */
    public static void printInvalidWarehouseLocation(int lineNumber) {
        System.out.println("Invalid location in warehouse file at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for an invalid warehouse cell type.
     *
     * @param lineNumber CSV line number
     */
    public static void printInvalidWarehouseCellType(int lineNumber) {
        System.out.println("Invalid cell type at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for a shelf/restricted-location overlap.
     *
     * @param lineNumber CSV line number
     */
    public static void printWarehouseOverlap(int lineNumber) {
        System.out.println("Restricted location overlaps shelf at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for a restricted location with a shelf type.
     *
     * @param lineNumber CSV line number
     */
    public static void printRestrictedShelfType(int lineNumber) {
        System.out.println("Shelf Type cannot be defined for Restricted Location at line "
                + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for an invalid shelf type.
     *
     * @param lineNumber CSV line number
     */
    public static void printInvalidShelfType(int lineNumber) {
        System.out.println("Invalid shelf type at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for a shelf type mismatch at an existing shelf.
     *
     * @param lineNumber CSV line number
     */
    public static void printShelfTypeMismatch(int lineNumber) {
        System.out.println("Shelf Type mismatched at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for an employees CSV line with too few fields.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectEmployeesLine(int lineNumber) {
        System.out.println("Incorrect Employees line at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for invalid employee details.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectEmployeeDetails(int lineNumber) {
        System.out.println("Incorrect Employee Details at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for an invalid employee designation.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectEmployeeDesignation(int lineNumber) {
        System.out.println("Incorrect Employee Designation at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for a payslips CSV line with an invalid structure.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectPayslipsLine(int lineNumber) {
        System.out.println("Incorrect Payslips line at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for missing payslip employee identity details.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectPayslipEmployeeDetails(int lineNumber) {
        System.out.println("Incorrect Employee Details at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the message for invalid payslip salary details.
     *
     * @param lineNumber CSV line number
     */
    public static void printIncorrectEmployeeSalaryDetails(int lineNumber) {
        System.out.println("Incorrect Employee Salary details at line " + lineNumber + ". Skipping this line.");
    }

    /**
     * Prints the Assignment 2 welcome message.
     */
    public static void printWelcomeA2() {
        System.out.println("Welcome to Warehouse Manager Assignment 2.");
    }
}
