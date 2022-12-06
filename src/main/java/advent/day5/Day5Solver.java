package advent.day5;

import advent.ScannerFactory;
import advent.Solution;
import advent.Solver;

import java.util.Objects;
import java.util.Scanner;

final class Day5Solver implements Solver, ScannerFactory {
    private final String resource;

    Day5Solver(final String resource) {
        this.resource = resource;
    }

    Day5Solver() {
        this("input.txt");
    }

    @Override
    public Solution solve() {
        ShipScanner shipScanner = new ShipScanner(this);
        Ship shipPart1 = shipScanner.scan(CraneMode.ONE_AT_A_TIME);
        Ship shipPart2 = shipScanner.scan(CraneMode.MULTIPLE_CRATES_AT_ONCE);

        try (Scanner scanner = newScanner()) {
            StepScanner stepScanner = new StepScanner(scanner);
            while (stepScanner.hasNextStep()) {
                Step step = stepScanner.nextStep();
                assert step != null;

                shipPart1.moveCrates(step);
                shipPart2.moveCrates(step);
            }
        }

        System.out.println(shipPart1.topCrates());
        System.out.println(shipPart2.topCrates());
        return new Solution(shipPart1.topCrates(), shipPart2.topCrates());
    }

    @Override
    public Scanner newScanner() {
        return new Scanner(Objects.requireNonNull(getClass().getResourceAsStream(resource)));
    }

    public static void main(String[] args) {
        new Day5Solver().solve();
    }
}
