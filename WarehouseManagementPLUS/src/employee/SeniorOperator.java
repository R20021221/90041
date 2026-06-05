package employee;

/**
 * Senior operator role that can operate warehouse shifts.
 */
public class SeniorOperator extends Employee implements ShiftCapable {

    /**
     * Creates a senior operator employee.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param managerId direct manager ID, or empty when none is supplied
     */
    public SeniorOperator(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.SENIOR_OPERATOR, baseSalary, managerId);
    }
}
