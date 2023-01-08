package advent.day15;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SensorBeaconScanner implements Iterator<SensorBeacon> {
    private static final Pattern REGEX = Pattern.compile("Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");
    private Scanner scanner;

    public SensorBeaconScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public SensorBeacon next() {
        String line = scanner.nextLine();
        Matcher matcher = REGEX.matcher(line);
        if (matcher.matches()) {
            return SensorBeacon.ofGridPositions(
                    new GridPosition(
                            Integer.parseInt(matcher.group(1)),
                            Integer.parseInt(matcher.group(2))
                    ),
                    new GridPosition(
                            Integer.parseInt(matcher.group(3)),
                            Integer.parseInt(matcher.group(4))
                    )
            );
        } else {
            return null;
        }
    }
}
