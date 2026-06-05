package payroll;

/**
 * Stores one payslip record loaded from or written to the payslip CSV file.
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

    /**
     * Creates a payslip with all salary components already calculated.
     *
     * @param employeeId employee ID
     * @param employeeName employee name
     * @param basePay base salary component
     * @param deliveredItemPay pay earned from delivered items
     * @param hitsPenalty penalty from wall hits
     * @param restrictedAreaPenalty penalty from restricted-area hits
     * @param reporteesManagingPay supervisor pay for managing reportees
     * @param netSalary final salary after additions and penalties
     */
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

    /**
     * Returns the employee ID for this payslip.
     *
     * @return employee ID
     */
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Returns the employee name for this payslip.
     *
     * @return employee name
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * Returns the base salary component.
     *
     * @return base pay
     */
    public double getBasePay() {
        return this.basePay;
    }

    /**
     * Returns the pay earned from delivered items.
     *
     * @return delivered item pay
     */
    public double getDeliveredItemPay() {
        return this.deliveredItemPay;
    }

    /**
     * Returns the total wall-hit penalty.
     *
     * @return hits penalty
     */
    public double getHitsPenalty() {
        return this.hitsPenalty;
    }

    /**
     * Returns the total restricted-area penalty.
     *
     * @return restricted-area penalty
     */
    public double getRestrictedAreaPenalty() {
        return this.restrictedAreaPenalty;
    }

    /**
     * Returns the supervisor pay earned from direct reportees.
     *
     * @return reportees management pay
     */
    public double getReporteesManagingPay() {
        return this.reporteesManagingPay;
    }

    /**
     * Returns the final salary after additions and penalties.
     *
     * @return net salary
     */
    public double getNetSalary() {
        return this.netSalary;
    }
}
