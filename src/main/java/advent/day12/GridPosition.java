package advent.day12;

record GridPosition(int x, int y) {
    GridPosition[] adjacentPositions() {
        return new GridPosition[] {
                new GridPosition(x - 1, y),
                new GridPosition(x + 1, y),
                new GridPosition(x, y - 1),
                new GridPosition(x, y + 1)
        };
    }

    public boolean isAdjacentTo(final GridPosition o) {
        return Math.abs(x - o.x) + Math.abs(y - o.y) == 1;
    }
}
