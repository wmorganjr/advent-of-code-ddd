package advent.day09;

final class Knot {
    private final int i;
    private GridPosition gridPosition;

    Knot(final int i, final GridPosition gridPosition) {
        this.i = i;
        this.gridPosition = gridPosition;
    }

    void move(final Direction direction) {
        gridPosition = direction.move(gridPosition);
    }

    int distanceFrom(final Knot o) {
        return Math.max(Math.abs(gridPosition.x() - o.gridPosition.x()),
                Math.abs(gridPosition.y() - o.gridPosition.y()));
    }

    void moveToward(final Knot o) {
        int dx = comparePositions(o.gridPosition.x(), gridPosition.x());
        int dy = comparePositions(o.gridPosition.y(), gridPosition.y());

        gridPosition = new GridPosition(gridPosition.x() + dx, gridPosition.y() + dy);
    }

    GridPosition gridPosition() {
        return gridPosition;
    }

    private int comparePositions(final int x, final int y) {
        // This is the same as the implementation of Integer.compare,
        // but not the interface, where the method documentation only
        // states that a positive (or negative) value will be returned,
        // but not that the value will be 1 (or -1). We actually need
        // the values to be -1, 0, or 1.
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Knot{" +
                "i=" + i +
                ", gridPosition=" + gridPosition +
                '}';
    }
}
