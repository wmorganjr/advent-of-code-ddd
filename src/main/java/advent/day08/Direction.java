package advent.day08;

enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    GridPosition next(GridPosition cur) {
        return switch (this) {
            case NORTH -> new GridPosition(cur.x(), cur.y() - 1);
            case SOUTH -> new GridPosition(cur.x(), cur.y() + 1);
            case EAST -> new GridPosition(cur.x() + 1, cur.y());
            case WEST -> new GridPosition(cur.x() - 1, cur.y());
        };
    }

    boolean isNorthSouth() {
        return this == NORTH || this == SOUTH;
    }

    boolean isEastWest() {
        return ! isNorthSouth();
    }
}
