package advent.day14;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

final class RockPathScanner implements Iterator<RockPath> {
    private final Scanner scanner;

    RockPathScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public RockPath next() {
        String line = scanner.nextLine();
        List<GridPosition> gridPositions = Arrays.stream(line.split(" -> "))
                .map(GridPosition::parse)
                .collect(Collectors.toList());
        return new RockPath(gridPositions);
    }
}
