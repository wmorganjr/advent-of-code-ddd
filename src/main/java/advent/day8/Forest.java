package advent.day8;

import java.util.*;

final class Forest {
    private final int width;
    private final int length;
    private final Tree[][] grid;
    private final LinkedList<GridPosition> gridPositions;

    Forest(final int width, final int length) {
        this.width = width;
        this.length = length;
        this.grid = new Tree[width][length];
        this.gridPositions = new LinkedList<>();
    }

    void putTree(final int x, final int y, final char c) {
        grid[y][x] = Tree.ofCharacter(c);
        gridPositions.add(new GridPosition(x, y));
    }

    boolean hasTreeAt(final int x, final int y) {
        return x >= 0 && x < width && y >=0 && y < length;
    }

    boolean hasTreeAt(final GridPosition gridPosition) {
        return hasTreeAt(gridPosition.x(), gridPosition.y());
    }

    Tree treeAt(final GridPosition gridPosition) {
        return treeAt(gridPosition.x(), gridPosition.y());
    }


    Tree treeAt(final int x, final int y) {
        return grid[x][y];
    }

    int width() {
        return width;
    }

    int length() {
        return length;
    }

    LineOfSight lineOfSightFrom(final Direction facing, final GridPosition gridPosition) {
        return new LineOfSight(gridPosition, facing);
    }

    Iterable<LineOfSight> linesOfSight() {
        LinkedList<LineOfSight> ret = new LinkedList<>();

        ret.addAll(linesOfSight(Direction.NORTH));
        ret.addAll(linesOfSight(Direction.SOUTH));
        ret.addAll(linesOfSight(Direction.EAST));
        ret.addAll(linesOfSight(Direction.WEST));

        return ret;
    }

    Iterator<GridPosition> gridPositionIterator() {
        return gridPositions.iterator();
    }

    private Collection<LineOfSight> linesOfSight(final Direction facing) {
        int arrayLength = facing.isNorthSouth() ? width : length;
        ArrayList<LineOfSight> ret = new ArrayList<>(arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            GridPosition gridPosition = gridPositionOfFacing(facing, i);
            ret.add(new LineOfSight(gridPosition, facing));
        }

        return ret;
    }

    private GridPosition gridPositionOfFacing(final Direction facing, final int i) {
        return switch (facing) {
            case NORTH -> new GridPosition(i, length - 1);
            case SOUTH -> new GridPosition(i, 0);
            case EAST -> new GridPosition(0, i);
            case WEST ->  new GridPosition(width - 1, i);
        };
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                stringBuilder.append(treeAt(new GridPosition(x, y)).height());
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }
}
