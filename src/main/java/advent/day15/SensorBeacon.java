package advent.day15;

import java.util.function.Consumer;

record SensorBeacon(GridPosition sensor, GridPosition beacon, int distance) {
    static SensorBeacon ofGridPositions(GridPosition sensor, GridPosition beacon) {
        return new SensorBeacon(sensor, beacon, sensor.manhattanDistance(beacon));
    }

    boolean coversPosition(final GridPosition gridPosition) {
        return distance >= sensor.manhattanDistance(gridPosition);
    }

    boolean overlapsRow(int y) {
        return distance >= Math.abs(y - sensor().y());
    }

    int sensorDistanceY(int y) {
        return Math.abs(sensor.y() - y);
    }

    int sensorDistanceX(int x) {
        return Math.abs(sensor.x() - x);
    }

    int beaconDistanceY(int y) {
        return Math.abs(beacon.y() - y);
    }

    int beaconDistanceX(int x) {
        return Math.abs(beacon.x() - x);
    }

    void forEachPeripheralPoint(int maxX, int maxY, Consumer<? super GridPosition> f) {
        int d = distance();

        for (int i = 0; i < d; i++) {
            int di = d - i;

            // One unit to the right of the top-right edge of the diamond
            GridPosition positionB = new GridPosition(sensor.x() + i + 1, sensor.y() - di);
            if (positionB.isWithinBounds(maxX, maxY)) {
                f.accept(positionB);
            }

            // One unit below the bottom-right edge of the diamond
            GridPosition positionA = new GridPosition(sensor.x() + i, sensor.y() + di + 1);
            if (positionA.isWithinBounds(maxX, maxY)) {
                f.accept(positionA);
            }

            // One unit to the left of the bottom-left edge of the diamond
            GridPosition positionC = new GridPosition(sensor.x() - i - 1, sensor.y() + di);
            if (positionC.isWithinBounds(maxX, maxY)) {
                f.accept(positionC);
            }

            // One unit above the top-left edge of the diamond
            GridPosition positionD = new GridPosition(sensor.x() - i, sensor.y() - di - 1);
            if (positionD.isWithinBounds(maxX, maxY)) {
                f.accept(positionD);
            }
        }
    }
}
