package advent.day09;

record GridPosition(int x, int y) {
    static GridPosition ORIGIN = new GridPosition(0, 0);
}
