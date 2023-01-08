package advent.day15;

import java.util.*;
import java.util.stream.Collectors;

final class TunnelNetwork {
    private final List<SensorBeacon> sensorBeacons;
    private final Set<GridPosition> beaconPositions;
    private volatile GridPosition missingBeacon;

    TunnelNetwork(List<SensorBeacon> sensorBeacons) {
        this.sensorBeacons = new LinkedList<>(sensorBeacons);
        this.beaconPositions = this.sensorBeacons.stream().map(SensorBeacon::beacon).collect(Collectors.toSet());
    }

    int countNonBeaconPositions(int y) {
        // Performance optimization. We only need to check the beacons which
        // overlap with the row under consideration.
        List<SensorBeacon> feasibleBeacons = sensorBeacons.stream()
                .filter(sensorBeacon -> sensorBeacon.overlapsRow(y))
                .collect(Collectors.toList());

        int count = 0;

        for (GridPosition gridPosition : new GridRow(y)) {
            if (cannotContainBeacon(gridPosition, feasibleBeacons)) {
                count++;
            }
        }

        return count;
    }

    private boolean cannotContainBeacon(GridPosition gridPosition, List<SensorBeacon> searchList) {
        for (SensorBeacon sensorBeacon : searchList) {
            if (sensorBeacon.coversPosition(gridPosition)) {
                return ! beaconPositions.contains(gridPosition);
            }
        }

        return false;
    }

    private boolean cannotContainBeacon(final GridPosition gridPosition) {
        return cannotContainBeacon(gridPosition, sensorBeacons);
    }

    GridPosition findMissingBeacon(int maxX, int maxY) {
        for (SensorBeacon sensorBeacon : sensorBeacons) {
            sensorBeacon.forEachPeripheralPoint(maxX, maxY, this::setMissingBeaconIfUncovered);
            if (missingBeacon != null) {
                break;
            }
        }

        return missingBeacon;
    }

    void setMissingBeaconIfUncovered(GridPosition gridPosition) {
        for (SensorBeacon sensorBeacon : sensorBeacons) {
            if (sensorBeacon.coversPosition(gridPosition)) {
                return;
            }
        }

        missingBeacon = gridPosition;
    }

    private class GridRow implements Iterable<GridPosition> {
        private final int y;
        private int minX;
        private int maxX;

        GridRow(final int y) {
            this.y = y;
            setXRange();
        }

        private void setXRange() {
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;

            for (SensorBeacon sensorBeacon : sensorBeacons) {
                int distance = sensorBeacon.distance();
                int yDistance = sensorBeacon.sensorDistanceY(y);
                int halfRowWidth = distance - yDistance;

                if (halfRowWidth >= 0) {
                    int leftX = sensorBeacon.sensor().x() - halfRowWidth;
                    int rightX = sensorBeacon.sensor().x() + halfRowWidth;
                    if (leftX < minX) {
                        minX = leftX;
                    }

                    if (rightX > maxX) {
                        maxX = rightX;
                    }
                }
            }

            this.minX = minX;
            this.maxX = maxX;
        }

        @Override
        public Iterator<GridPosition> iterator() {
            return new GridRowPositionIterator();
        }

        private class GridRowPositionIterator implements Iterator<GridPosition> {
            int x = minX - 1;

            @Override
            public boolean hasNext() {
                return x <= maxX;
            }

            @Override
            public GridPosition next() {
                x++;
                return new GridPosition(x, y);
            }
        }
    }
}
