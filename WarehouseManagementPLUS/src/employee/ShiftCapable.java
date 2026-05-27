package employee;

/**
 * Marks employee roles that can operate warehouse shifts.
 */
public interface ShiftCapable {

    /**
     * Returns the shift summary for this employee.
     *
     * @return shift summary
     */
    ShiftSummary getShiftSummary();
}
