package advent.day05;

import advent.ScannerFactory;
import advent.ScanningLifecycleSolver;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

final class Day5Solver2 extends ScanningLifecycleSolver<Step> implements ScannerFactory {
    private final String resource;

    private Ship shipPart1;
    private Ship shipPart2;

    Day5Solver2(final String resource) {
        this.resource = resource;
    }

    Day5Solver2() {
        this("input.txt");
    }

    @Override
    protected void start() {
        ShipScanner shipScanner = new ShipScanner(this);

        this.shipPart1 = shipScanner.scan(CraneMode.ONE_AT_A_TIME);
        this.shipPart2 = shipScanner.scan(CraneMode.MULTIPLE_CRATES_AT_ONCE);
    }

    @Override
    protected void next(final Step step) {
        assert step != null;

        shipPart1.moveCrates(step);
        shipPart2.moveCrates(step);
    }

    @Override
    protected void end() {
        setPart1Solution(shipPart1.topCrates());
        setPart2Solution(shipPart2.topCrates());
    }

    @Override
    protected Iterator<Step> domainObjectScanner(final Scanner scanner) {
        return new StepScanner(scanner);
    }

    @Override
    public Scanner newScanner() {
        return new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(resource)));
    }

    public static void main(String[] args) {
        new Day5Solver2().solve();
    }
}
