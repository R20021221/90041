package io;

import IOExceptions.InvalidLineException;
import IOExceptions.InvalidTypeException;
import employee.Designation;
import employee.Employee;
import employee.Operator;
import employee.PayrollManager;
import employee.SeniorOperator;
import employee.Supervisor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads employees CSV input and creates employee domain objects.
 */
public class EmployeeCsvReader {

    private static final int MIN_EMPLOYEE_FIELD_COUNT = 4;
    private static final int MANAGER_FIELD_INDEX = 4;

    /**
     * Opens and scans an employees CSV file.
     *
     * @param filePath employees CSV path
     * @return employees in file order
     * @throws FileNotFoundException if the file cannot be opened
     */
    public ArrayList<Employee> loadEmployees(String filePath) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            int lineNumber = 0;
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                lineNumber++;
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(",", -1);
                try {
                    Employee employee = parseEmployeeLine(fields, lineNumber);
                    employees.add(employee);
                } catch (InvalidLineException | InvalidTypeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        buildReportees(employees);
        return employees;
    }

    private Employee parseEmployeeLine(String[] fields, int lineNumber)
            throws InvalidLineException, InvalidTypeException {
        if (fields.length < MIN_EMPLOYEE_FIELD_COUNT) {
            throw new InvalidLineException(incorrectEmployeesLineMessage(lineNumber));
        }

        String employeeId = fields[0].trim();
        String employeeName = fields[1].trim();
        String managerId = fields.length > MANAGER_FIELD_INDEX ? fields[MANAGER_FIELD_INDEX].trim() : "";
        double baseSalary = parseBaseSalary(fields[3].trim());

        if (employeeId.isEmpty() || employeeName.isEmpty() || baseSalary <= 0) {
            throw new InvalidLineException(incorrectEmployeeDetailsMessage(lineNumber));
        }

        Designation designation = parseDesignation(fields[2].trim());
        if (designation == null) {
            throw new InvalidTypeException(incorrectEmployeeDesignationMessage(lineNumber));
        }

        return createEmployee(employeeId, employeeName, designation, baseSalary, managerId);
    }

    private double parseBaseSalary(String salaryText) {
        try {
            return Double.parseDouble(salaryText);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private Designation parseDesignation(String designationText) {
        try {
            return Designation.valueOf(designationText);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    private Employee createEmployee(String employeeId, String employeeName, Designation designation,
                                    double baseSalary, String managerId) {
        switch (designation) {
            case OPERATOR:
                return new Operator(employeeId, employeeName, baseSalary, managerId);
            case SENIOR_OPERATOR:
                return new SeniorOperator(employeeId, employeeName, baseSalary, managerId);
            case SUPERVISOR:
                return new Supervisor(employeeId, employeeName, baseSalary, managerId);
            case PAYROLL_MANAGER:
                return new PayrollManager(employeeId, employeeName, baseSalary, managerId);
            default:
                return null;
        }
    }

    private void buildReportees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            String managerId = employee.getManagerId();
            if (managerId == null || managerId.isEmpty()) {
                continue;
            }

            Employee manager = findEmployeeById(employees, managerId);
            if (manager instanceof Supervisor) {
                ((Supervisor) manager).addReportee(employee);
            }
        }
    }

    private Employee findEmployeeById(ArrayList<Employee> employees, String employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    private String incorrectEmployeesLineMessage(int lineNumber) {
        return "Incorrect Employees line at line " + lineNumber + ". Skipping this line.";
    }

    private String incorrectEmployeeDetailsMessage(int lineNumber) {
        return "Incorrect Employee Details at line " + lineNumber + ". Skipping this line.";
    }

    private String incorrectEmployeeDesignationMessage(int lineNumber) {
        return "Incorrect Employee Designation at line " + lineNumber + ". Skipping this line.";
    }
}
