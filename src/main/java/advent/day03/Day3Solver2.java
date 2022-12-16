package advent.day03;

import advent.ScanningLifecycleSolver;

import java.util.Scanner;

final class Day3Solver2 extends ScanningLifecycleSolver<ElfGroup> {
    private long prioritySum = 0;
    private long badgeSum = 0;

    @Override
    protected void next(final ElfGroup elfGroup) {
        prioritySum += elfGroup.sumRucksackPriorities();
        badgeSum += elfGroup.badgePriority();
    }

    @Override
    protected void end() {
        setPart1Solution(prioritySum);
        setPart2Solution(badgeSum);
    }

    public static void main(String[] args) {
        new Day3Solver2().solve();
    }

    @Override
    protected ElfGroupScanner domainObjectScanner(final Scanner scanner) {
        return new ElfGroupScanner(new RucksackScanner(scanner));
    }
}
