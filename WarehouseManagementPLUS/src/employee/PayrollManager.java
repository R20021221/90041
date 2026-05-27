package employee;

/**
 * Payroll manager role that manages summaries and payslips.
 */
public class PayrollManager extends Employee {

    public PayrollManager(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.PAYROLL_MANAGER, baseSalary, managerId);
    }
}
