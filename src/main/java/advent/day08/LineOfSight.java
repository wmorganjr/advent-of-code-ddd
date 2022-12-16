package advent.day08;

import java.util.Iterator;

record LineOfSight(GridPosition originalPosition, Direction direction) implements Iterable<GridPosition> {

    @Override
    public Iterator<GridPosition> iterator() {
        return new GridPositionIterator();
    }

    private class GridPositionIterator implements Iterator<GridPosition> {
        private GridPosition gridPosition = originalPosition;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public GridPosition next() {
            GridPosition currentGridPosition = gridPosition;
            gridPosition = direction().next(currentGridPosition);
            return currentGridPosition;
        }
    }
}
