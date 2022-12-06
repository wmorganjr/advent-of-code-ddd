package advent.day2;

import advent.ScanningLifecycleSolver;
import advent.ScanningSolver;
import advent.Solution;

import java.util.Iterator;
import java.util.Scanner;

final class Day2Solver2 extends ScanningLifecycleSolver<RoundTuple> {
    private long totalScorePart1 = 0;
    private long totalScorePart2 = 0;

    @Override
    protected void next(final RoundTuple roundTuple) {
        totalScorePart1 += roundTuple.part1Round().score();
        totalScorePart2 += roundTuple.part2Round().score();
    }

    @Override
    protected void end() {
        setPart1Solution(totalScorePart1);
        setPart2Solution(totalScorePart2);
    }

    public static void main(String[] args) {
        new Day2Solver2().solve();
    }

    @Override
    protected Iterator<RoundTuple> domainObjectScanner(final Scanner scanner) {
        return new RoundScanner(scanner);
    }
}
