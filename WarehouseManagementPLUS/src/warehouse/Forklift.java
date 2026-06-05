package warehouse;

/**
 * Forklift represents the player-controlled vehicle in the warehouse.
 * It manages position, movement, collision statistics, carried items,
 * and session state.
 */
public class Forklift {

    // Current row position of the forklift on the grid
    private int row;

    // Current column position of the forklift on the grid
    private int col;

    // Number of invalid movement attempts (wall/restricted/out of bounds)
    private int hits;

    // Number of successful moves
    private int moves;

    // Indicates whether the current warehouse shift is paused
    private boolean sessionPaused;

    // Item currently carried by the forklift (null if empty)
    private Item carriedItem;

    /**
     * Constructs a Forklift object.
     * Resets the forklift to its starting state.
     */
    public Forklift() {
        resetSessionState();
    }

    /**
     * Attempts to move the forklift in the given direction.
     * Only movement commands (U, D, L, R) are processed.
     * Non-movement commands are ignored.
     *
     * @param direction the movement direction entered by the user
     * @param gridSnapshot a snapshot of the warehouse grid cell types
     * @return true if the move was successful; false otherwise
     */
    public boolean move(String direction, CellType[][] gridSnapshot) {
        // Start with the current position
        int newRow = this.row;
        int newCol = this.col;

        // Determine the target cell based on direction
        switch (direction) {
            case Constants.MOVE_UP:
                newRow--;
                break;
            case Constants.MOVE_DOWN:
                newRow++;
                break;
            case Constants.MOVE_LEFT:
                newCol--;
                break;
            case Constants.MOVE_RIGHT:
                newCol++;
                break;
            default:
                // Not a movement command (e.g., T for deliver)
                return false;
        }

        // Validate and apply the movement
        return moveToNewPosition(gridSnapshot, newRow, newCol);
    }

    /**
     * Resets the forklift to its initial state.
     * This includes position, statistics, carried item,
     * and session pause status.
     */
    public void resetSessionState() {
        this.row = Constants.START_ROW;
        this.col = Constants.START_COL;
        this.moves = 0;
        this.hits = 0;
        this.sessionPaused = false;
        this.carriedItem = null;
    }

    /* ===== Simple getters / setters  */

    /**
     * Returns the forklift's current row.
     *
     * @return current row
     */
    public int getRow() { return this.row; }

    /**
     * Returns the forklift's current column.
     *
     * @return current column
     */
    public int getCol() { return this.col; }

    /**
     * Updates whether this forklift's current shift is paused.
     *
     * @param val true if the session should be marked as paused
     */
    public void setSessionPaused(boolean val) { this.sessionPaused = val; }

    /**
     * Returns whether the forklift is currently carrying an item.
     *
     * @return true if an item is being carried
     */
    public boolean isCarrying() { return this.carriedItem != null; }

    /**
     * Assigns an item to be carried by the forklift.
     *
     * @param item the item to pick up
     */
    public void pickUp(Item item) {
        this.carriedItem = item;
    }

    /**
     * Drops the currently carried item and returns it.
     *
     * @return the dropped item, or null if none was carried
     */
    public Item drop() {
        Item item = new Item(this.carriedItem);
        this.carriedItem = null;
        return item;
    }

    /**
     * Validates and applies movement to a new position.
     * This method enforces warehouse boundaries and obstacle rules.
     *
     * @param snapshot snapshot of the grid cell types
     * @param newRow proposed row position
     * @param newCol proposed column position
     * @return true if movement succeeds; false otherwise
     */
    private boolean moveToNewPosition(CellType[][] snapshot, int newRow, int newCol) {

        // Ensure the target position is within the inner warehouse boundary
        if (newRow >= 1 && newRow < snapshot.length - 1
                && newCol >= 1 && newCol < snapshot[0].length - 1) {

            // Determine the type of the target cell
            CellType target = snapshot[newRow][newCol];

            // Block movement into walls or restricted cells
            if (target == CellType.WALL || target == CellType.RESTRICTED) {
                this.hits++;
                return false;
            }

            // Valid movement: update position and statistics
            this.row = newRow;
            this.col = newCol;
            this.moves++;
            return true;
        }

        // Movement outside the grid counts as a collision
        this.hits++;
        return false;
    }
}
