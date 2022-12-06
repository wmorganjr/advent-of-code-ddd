package advent.day4;

import advent.ScanningLifecycleSolver;

import java.util.Iterator;
import java.util.Scanner;

final class Day4Solver extends ScanningLifecycleSolver<ElfPair> {
    private int rangesFullyContained = 0;
    private int rangesOverlapping = 0;

    @Override
    protected void next(final ElfPair elfPair) {
        if (elfPair.rangeFullyContained()) {
            rangesFullyContained++;
        }

        if (elfPair.rangeOverlaps()) {
            rangesOverlapping++;
        }
    }

    @Override
    protected void end() {
        setPart1Solution(rangesFullyContained);
        setPart2Solution(rangesOverlapping);
    }

    @Override
    protected Iterator<ElfPair> domainObjectScanner(final Scanner scanner) {
        return new ElfPairScanner(scanner);
    }

    public static void main(String[] args) {
        new Day4Solver().solve();
    }
}
