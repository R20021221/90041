package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import payroll.Payslip;

/**
 * Writes payslip records to the fixed payslip CSV file.
 */
public class PayslipCsvWriter {

    private static final String HEADER =
            "employee_id,employee_name,base_pay,delivered_item_pay,hits_penalty,"
                    + "restricted_area_penalty,reportees_managing_pay,net_salary";

    /**
     * Writes payslips to CSV, replacing the target file.
     *
     * @param filePath payslip CSV path
     * @param payslips payslips to write
     * @throws FileNotFoundException if the file cannot be opened for writing
     */
    public void writePayslips(String filePath, ArrayList<Payslip> payslips) throws FileNotFoundException {
        File payslipFile = new File(filePath);
        File parent = payslipFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(payslipFile)) {
            writer.println(HEADER);
            if (payslips != null) {
                for (Payslip payslip : payslips) {
                    writer.println(formatPayslip(payslip));
                }
            }
            writer.flush();
        }
    }

    private String formatPayslip(Payslip payslip) {
        return payslip.getEmployeeId() + ","
                + payslip.getEmployeeName() + ","
                + formatMoney(payslip.getBasePay()) + ","
                + formatMoney(payslip.getDeliveredItemPay()) + ","
                + formatMoney(payslip.getHitsPenalty()) + ","
                + formatMoney(payslip.getRestrictedAreaPenalty()) + ","
                + formatMoney(payslip.getReporteesManagingPay()) + ","
                + formatMoney(payslip.getNetSalary());
    }

    private String formatMoney(double value) {
        return String.format("%.2f", value);
    }
}
