package advent.day15;

import advent.ScanningLifecycleSolver;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

final class Day15Solver extends ScanningLifecycleSolver<SensorBeacon> {
    private final LinkedList<SensorBeacon> sensorBeacons = new LinkedList<>();
    private int part1Row = 2000000;
    private int part2MaxX = 4000000;
    private int part2MaxY = 4000000;

    @Override
    protected void next(final SensorBeacon sensorBeacon) {
        assert sensorBeacon != null;

        sensorBeacons.add(sensorBeacon);
    }

    @Override
    protected void end() {
        TunnelNetwork tunnelNetwork = new TunnelNetwork(Collections.unmodifiableList(sensorBeacons));
        setPart1Solution(tunnelNetwork.countNonBeaconPositions(part1Row));

        GridPosition missingBeacon = tunnelNetwork.findMissingBeacon(part2MaxX, part2MaxY);
        long tuningFrequency = missingBeacon.x() * 4000000L + missingBeacon.y();
        setPart2Solution(tuningFrequency);
    }

    @Override
    protected Iterator<SensorBeacon> domainObjectScanner(final Scanner scanner) {
        return new SensorBeaconScanner(scanner);
    }

    void setSample() {
        setInput("sample.txt");
        part1Row = 10;
        part2MaxX = 20;
        part2MaxY = 20;
    }
}
