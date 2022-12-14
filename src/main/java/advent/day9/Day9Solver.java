package advent.day9;

import advent.ScanningLifecycleSolver;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

final class Day9Solver extends ScanningLifecycleSolver<Motion> {
    private final String input;
    private final Bridge bridgePart1;
    private final Bridge bridgePart2;

    Day9Solver(final String input) {
        this.input = input;
        this.bridgePart1 = new Bridge(2);
        this.bridgePart2 = new Bridge(10);
    }

    Day9Solver() {
        this("input.txt");
    }

    @Override
    protected void next(final Motion motion) {
        bridgePart1.moveHead(motion);
        bridgePart2.moveHead(motion);
    }

    @Override
    protected void end() {
        setPart1Solution(bridgePart1.countPositionsVisitedByTail());
        setPart2Solution(bridgePart2.countPositionsVisitedByTail());
    }

    @Override
    protected Iterator<Motion> domainObjectScanner(final Scanner scanner) {
        return new MotionScanner(scanner);
    }

    @Override
    protected Scanner newScanner() {
        return new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(input)));
    }

    public static void main(String[] args) {
        new Day9Solver("sample2.txt").solve();
    }
}
