package employee;

/**
 * Employee role that can operate warehouse shifts.
 */
public class Operator extends Employee implements ShiftCapable {

    /**
     * Creates an operator employee.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param managerId direct manager ID, or empty when none is supplied
     */
    public Operator(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.OPERATOR, baseSalary, managerId);
    }
}
