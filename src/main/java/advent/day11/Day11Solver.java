package advent.day11;

import advent.Solution;
import advent.Solver;
import advent.SolverSupport;

final class Day11Solver extends SolverSupport implements Solver {
    @Override
    public Solution solve() {
        MonkeyGroupScanner monkeyGroupScanner = new MonkeyGroupScanner(newScanner());
        MonkeyGroup monkeyGroup = monkeyGroupScanner.scanMonkeyGroup();

        for (int round = 1; round <= 20; round++) {
            monkeyGroup.doRound(3);
        }

        setPart1Solution(monkeyGroup.monkeyBusiness());

        monkeyGroup = new MonkeyGroupScanner(newScanner()).scanMonkeyGroup();

        for (int round = 1; round <= 10000; round++) {
            monkeyGroup.doRound(1);
        }

        setPart2Solution(monkeyGroup.monkeyBusiness());

        return solution();
    }

    public static void main(String[] args) {
        Day11Solver day11Solver = new Day11Solver();
        day11Solver.setInput("sample.txt");
        day11Solver.solve();
    }
}
