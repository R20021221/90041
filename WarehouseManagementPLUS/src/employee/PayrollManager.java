package employee;

/**
 * Payroll manager role that manages summaries and payslips.
 */
public class PayrollManager extends Employee {

    /**
     * Creates a payroll manager employee.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param managerId direct manager ID, or empty when none is supplied
     */
    public PayrollManager(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.PAYROLL_MANAGER, baseSalary, managerId);
    }
}
