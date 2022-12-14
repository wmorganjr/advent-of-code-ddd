package advent.day9;

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
        int dx = comparePositions(gridPosition.x(), o.gridPosition.x());
        int dy = comparePositions(gridPosition.y(), o.gridPosition.y());

        gridPosition = new GridPosition(gridPosition.x() + dx, gridPosition.y() + dy);
    }

    GridPosition gridPosition() {
        return gridPosition;
    }

    private int comparePositions(final int a, final int b) {
        return (int) Math.signum(Integer.compare(b, a));
    }

    @Override
    public String toString() {
        return "Knot{" +
                "i=" + i +
                ", gridPosition=" + gridPosition +
                '}';
    }
}
