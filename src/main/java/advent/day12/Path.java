package advent.day12;

record Path(GridPosition lastPosition, Path path, int steps) {
    static final Path ofStart(GridPosition startPosition) {
        return new Path(startPosition, null, 0);
    }

    Path add(GridPosition next) {
        return new Path(next, this, steps + 1);
    }
}
