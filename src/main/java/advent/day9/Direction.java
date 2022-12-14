package advent.day9;

enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    static Direction ofString(final String string) {
        return switch(string) {
            case "U" -> UP;
            case "D" -> DOWN;
            case "R" -> RIGHT;
            case "L" -> LEFT;
            default -> null;
        };
    }

    GridPosition move(final GridPosition gridPosition) {
        return switch(this) {
            case UP -> new GridPosition(gridPosition.x(), gridPosition.y() + 1);
            case DOWN -> new GridPosition(gridPosition.x(), gridPosition.y() - 1);
            case RIGHT -> new GridPosition(gridPosition.x() + 1, gridPosition.y());
            case LEFT -> new GridPosition(gridPosition.x() - 1, gridPosition.y());
        };
    }
}
