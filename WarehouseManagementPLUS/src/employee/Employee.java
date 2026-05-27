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

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public Designation getDesignation() {
        return this.designation;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getManagerId() {
        return this.managerId;
    }

    public ShiftSummary getShiftSummary() {
        return this.shiftSummary;
    }
}
