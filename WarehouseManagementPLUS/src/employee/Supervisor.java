package employee;

import java.util.ArrayList;

/**
 * Supervisor role that can operate shifts and later view direct reportees.
 */
public class Supervisor extends Employee implements ShiftCapable {

    private final ArrayList<Employee> reportees;

    public Supervisor(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.SUPERVISOR, baseSalary, managerId);
        this.reportees = new ArrayList<>();
    }

    public void addReportee(Employee employee) {
        this.reportees.add(employee);
    }

    public ArrayList<Employee> getReportees() {
        return new ArrayList<>(this.reportees);
    }
}
