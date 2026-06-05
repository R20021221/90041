package employee;

/**
 * Base class for all employees loaded from the employees CSV file.
 */
public abstract class Employee {

    private final String employeeId;
    private final String employeeName;
    private final Designation designation;
    private final double baseSalary;
    private final String managerId;
    private final ShiftSummary shiftSummary;

    /**
     * Creates an employee with common details.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param designation employee designation
     * @param baseSalary base salary
     * @param managerId manager ID, or empty when none is supplied
     */
    protected Employee(String employeeId, String employeeName, Designation designation,
                       double baseSalary, String managerId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.managerId = managerId;
        this.shiftSummary = new ShiftSummary();
    }

    /**
     * Returns the unique ID used to log in and match payslip records.
     *
     * @return employee ID
     */
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Returns the employee's display name.
     *
     * @return employee name
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * Returns the employee's assigned role.
     *
     * @return employee designation
     */
    public Designation getDesignation() {
        return this.designation;
    }

    /**
     * Returns the employee's base salary before shift bonuses or penalties.
     *
     * @return base salary
     */
    public double getBaseSalary() {
        return this.baseSalary;
    }

    /**
     * Returns the direct manager ID loaded from the employees CSV file.
     *
     * @return manager ID, or an empty string when no manager is supplied
     */
    public String getManagerId() {
        return this.managerId;
    }

    /**
     * Returns the shift summary that stores this employee's current-session results.
     *
     * @return shift summary
     */
    public ShiftSummary getShiftSummary() {
        return this.shiftSummary;
    }
}
