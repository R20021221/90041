package employee;

/**
 * Senior operator role that can operate warehouse shifts.
 */
public class SeniorOperator extends Employee implements ShiftCapable {

    public SeniorOperator(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.SENIOR_OPERATOR, baseSalary, managerId);
    }
}
