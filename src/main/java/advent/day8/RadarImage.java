package advent.day8;

import java.util.Iterator;

final class RadarImage implements Iterable<GridPosition> {
    private final Forest forest;
    private final boolean[][] treeVisibilities;
    private long visibleTreeCount;

    RadarImage(final Forest forest) {
        this.forest = forest;
        this.treeVisibilities = new boolean[forest.width()][forest.length()];
        this.visibleTreeCount = 0;
    }

    void markTreesVisible(final LineOfSight lineOfSight) {
        int minimumHeight = -1;
        for (GridPosition gridPosition : lineOfSight) {
            if (! forest.hasTreeAt(gridPosition)) {
                break;
            }

            Tree tree = forest.treeAt(gridPosition);
            if (tree.height() > minimumHeight) {
                minimumHeight = tree.height();
                markTreeVisible(gridPosition);
            }
        }
    }

    private void markTreeVisible(final GridPosition gridPosition) {
        if (! treeVisibilities[gridPosition.x()][gridPosition.y()]) {
            visibleTreeCount++;
            treeVisibilities[gridPosition.x()][gridPosition.y()] = true;
        }
    }

    long visibleTreeCount() {
        return visibleTreeCount;
    }

    long scenicScore(GridPosition gridPosition) {
        return scenicScoreComponent(gridPosition, Direction.NORTH) *
                scenicScoreComponent(gridPosition, Direction.SOUTH) *
                scenicScoreComponent(gridPosition, Direction.EAST) *
                scenicScoreComponent(gridPosition, Direction.WEST);
    }

    private long scenicScoreComponent(final GridPosition startingGridPosition, final Direction direction) {
        int treeHeight = forest.treeAt(startingGridPosition).height();
        LineOfSight lineOfSight = forest.lineOfSightFrom(direction, startingGridPosition);

        Iterator<GridPosition> gridPositionIterator = lineOfSight.iterator();

        // The starting tree doesn't count
        gridPositionIterator.next();
        int treesVisible = 0;

        while (gridPositionIterator.hasNext()) {
            GridPosition gridPosition = gridPositionIterator.next();

            if (! forest.hasTreeAt(gridPosition)) {
                break;
            }

            treesVisible++;

            if (forest.treeAt(gridPosition).height() >= treeHeight) {
                break;
            }
        }

        return treesVisible;
    }

    @Override
    public Iterator<GridPosition> iterator() {
        return forest.gridPositionIterator();
    }

    @Override
    public String toString() {
        StringBuilder treeVisibilitiesStringBuilder = new StringBuilder();

        for (int y = 0; y < forest.length(); y++) {
            for (int x = 0; x < forest.width(); x++) {
                if (treeVisibilities[x][y]) {
                    treeVisibilitiesStringBuilder.append(forest.treeAt(new GridPosition(x, y)).height());
                } else {
                    treeVisibilitiesStringBuilder.append('.');
                }
            }
            treeVisibilitiesStringBuilder.append('\n');
        }

        for (int y = 0; y < forest.length(); y++) {
            for (int x = 0; x < forest.width(); x++) {
                treeVisibilitiesStringBuilder.append('[');
                treeVisibilitiesStringBuilder.append(scenicScore(new GridPosition(x, y)));
                treeVisibilitiesStringBuilder.append(']');
            }
            treeVisibilitiesStringBuilder.append('\n');
        }

        return treeVisibilitiesStringBuilder.toString();
    }
}
