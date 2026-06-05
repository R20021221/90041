package employee;

import java.util.ArrayList;

/**
 * Supervisor role that can operate shifts and later view direct reportees.
 */
public class Supervisor extends Employee implements ShiftCapable {

    private final ArrayList<Employee> reportees;

    /**
     * Creates a supervisor employee.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param baseSalary base salary
     * @param managerId direct manager ID, or empty when none is supplied
     */
    public Supervisor(String employeeId, String employeeName, double baseSalary, String managerId) {
        super(employeeId, employeeName, Designation.SUPERVISOR, baseSalary, managerId);
        this.reportees = new ArrayList<>();
    }

    /**
     * Adds one direct reportee to this supervisor.
     *
     * @param employee employee that reports directly to this supervisor
     */
    public void addReportee(Employee employee) {
        this.reportees.add(employee);
    }

    /**
     * Returns a copy of the direct reportee list.
     *
     * @return direct reportees in employees-file order
     */
    public ArrayList<Employee> getReportees() {
        return new ArrayList<>(this.reportees);
    }
}
