package advent.day15;

record GridPosition(int x, int y) {
    int manhattanDistance(GridPosition o) {
        return xDistance(o) + yDistance(o);
    }

    int yDistance(GridPosition o) {
        return Math.abs(y - o.y);
    }

    int xDistance(GridPosition o) {
        return Math.abs(x - o.x);
    }

    boolean isWithinBounds(final int maxX, final int maxY) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
