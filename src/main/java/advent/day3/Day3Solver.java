package advent.day3;

import advent.Solution;

import java.util.Objects;
import java.util.Scanner;

final class Day3Solver {
    Solution solve() {
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Day3Solver.class.getResourceAsStream("input.txt")))) {
            RucksackScanner rucksackScanner = new RucksackScanner(scanner);
            ElfGroupScanner elfGroupScanner = new ElfGroupScanner(rucksackScanner);

            long prioritySum = 0;
            long badgeSum = 0;

            while (elfGroupScanner.hasNextElfGroup()) {
                ElfGroup elfGroup = elfGroupScanner.nextElfGroup();
                prioritySum += elfGroup.sumRucksackPriorities();
                badgeSum += elfGroup.badgePriority();
            }

            System.out.println(prioritySum);
            System.out.println(badgeSum);

            return new Solution(prioritySum, badgeSum);
        }


    }

    public static void main(String[] args) {
        new Day3Solver().solve();
    }
}
