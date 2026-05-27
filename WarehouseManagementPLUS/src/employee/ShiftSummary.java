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

    public int getDeliveredItemCount() {
        return this.deliveredItemCount;
    }

    public int getWallHitCount() {
        return this.wallHitCount;
    }

    public int getRestrictedAreaHitCount() {
        return this.restrictedAreaHitCount;
    }
}
