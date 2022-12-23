package advent.day14;

import advent.ScanningLifecycleSolver;

import java.util.Iterator;
import java.util.Scanner;

final class Day14Solver extends ScanningLifecycleSolver<RockPath> {
    public static final GridPosition STARTING_SAND_POSITION = new GridPosition(500, 0);
    CaveBuilder caveBuilder = new CaveBuilder();

    @Override
    protected void next(final RockPath rockPath) {
        rockPath.forEachPosition(caveBuilder::addRock);
    }

    @Override
    protected void end() {
        part1();
        part2();
    }

    private void part1() {
        caveBuilder.setAbyssOffset(+1);
        caveBuilder.setFloorOffset(+2);
        Cave cave = caveBuilder.build();

        SandDestination sandDestination = SandDestination.NONE;
        while (! sandDestination.isAbyss()) {
            sandDestination = cave.dropSand(STARTING_SAND_POSITION);
        }

        setPart1Solution(cave.unitsOfSand());
    }

    private void part2() {
        caveBuilder.setFloorOffset(+2);
        caveBuilder.setAbyssOffset(+3);
        Cave cave = caveBuilder.build();

        SandDestination sandDestination = SandDestination.NONE;
        while (! sandDestination.equals(STARTING_SAND_POSITION)) {
            sandDestination = cave.dropSand(STARTING_SAND_POSITION);
        }

        setPart2Solution(cave.unitsOfSand());
    }

    @Override
    protected Iterator<RockPath> domainObjectScanner(final Scanner scanner) {
        return new RockPathScanner(scanner);
    }
}
