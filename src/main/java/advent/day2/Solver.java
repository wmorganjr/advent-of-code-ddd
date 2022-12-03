package advent.day2;

import advent.Solution;

import java.util.Objects;
import java.util.Scanner;

final class Solver {
    Solution solve() {
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Solver.class.getResourceAsStream("input.txt")))) {
            RoundScanner roundScanner = new RoundScanner(scanner);

            long totalScorePart1 = 0;
            long totalScorePart2 = 0;
            while (roundScanner.hasNextRound()) {
                Round roundPart1 = roundScanner.nextRoundPart1();
                totalScorePart1 += roundPart1.score();

                Round roundPart2 = roundScanner.currentRoundPart2();
                totalScorePart2 += roundPart2.score();
            }

            System.out.println(totalScorePart1);
            System.out.println(totalScorePart2);

            return new Solution(totalScorePart1, totalScorePart2);
        }
    }

    public static void main(String[] args) {
        new Solver().solve();
    }
}
