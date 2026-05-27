package payroll;

/**
 * Placeholder model for payslip data loaded from or written to CSV.
 */
public class Payslip {

    private final String employeeId;
    private final String employeeName;
    private final double basePay;
    private final double deliveredItemPay;
    private final double hitsPenalty;
    private final double restrictedAreaPenalty;
    private final double reporteesManagingPay;
    private final double netSalary;

    public Payslip(String employeeId, String employeeName, double basePay, double deliveredItemPay,
                   double hitsPenalty, double restrictedAreaPenalty,
                   double reporteesManagingPay, double netSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basePay = basePay;
        this.deliveredItemPay = deliveredItemPay;
        this.hitsPenalty = hitsPenalty;
        this.restrictedAreaPenalty = restrictedAreaPenalty;
        this.reporteesManagingPay = reporteesManagingPay;
        this.netSalary = netSalary;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public double getBasePay() {
        return this.basePay;
    }

    public double getDeliveredItemPay() {
        return this.deliveredItemPay;
    }

    public double getHitsPenalty() {
        return this.hitsPenalty;
    }

    public double getRestrictedAreaPenalty() {
        return this.restrictedAreaPenalty;
    }

    public double getReporteesManagingPay() {
        return this.reporteesManagingPay;
    }

    public double getNetSalary() {
        return this.netSalary;
    }
}
