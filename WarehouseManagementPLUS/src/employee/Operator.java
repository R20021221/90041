package employee;

/**
 * Employee role that can operate warehouse shifts.
 */
public class Operator extends Employee implements ShiftCapable {

    public Operator(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.OPERATOR, baseSalary, managerId);
    }
}
