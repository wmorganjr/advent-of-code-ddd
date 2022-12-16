package advent.day03;

import advent.ScanningSolver;
import advent.Solution;

import java.util.Scanner;

final class Day3Solver extends ScanningSolver {

    @Override
    protected Solution solve(final Scanner scanner) {
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

    public static void main(String[] args) {
        new Day3Solver().solve();
    }
}
