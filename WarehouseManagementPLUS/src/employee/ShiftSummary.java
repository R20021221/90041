package employee;

/**
 * Tracks the shift results that belong to one employee.
 */
public class ShiftSummary {

    private int deliveredItemCount;
    private int wallHitCount;
    private int restrictedAreaHitCount;

    /**
     * Records one successfully delivered item.
     */
    public void recordDeliveredItem() {
        this.deliveredItemCount++;
    }

    /**
     * Records one attempted movement into a wall.
     */
    public void recordWallHit() {
        this.wallHitCount++;
    }

    /**
     * Records one attempted movement into a restricted area.
     */
    public void recordRestrictedAreaHit() {
        this.restrictedAreaHitCount++;
    }

    /**
     * Returns the number of items successfully delivered by this employee.
     *
     * @return delivered item count
     */
    public int getDeliveredItemCount() {
        return this.deliveredItemCount;
    }

    /**
     * Returns the number of attempted movements into walls or boundaries.
     *
     * @return wall hit count
     */
    public int getWallHitCount() {
        return this.wallHitCount;
    }

    /**
     * Returns the number of attempted movements into restricted areas.
     *
     * @return restricted-area hit count
     */
    public int getRestrictedAreaHitCount() {
        return this.restrictedAreaHitCount;
    }
}
