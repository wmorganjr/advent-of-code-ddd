package advent.day11;

import advent.Solution;
import advent.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day11SolverTest {

    @Test
    void solve() {
        Solution solution = new Day11Solver().solve();

        assertEquals(54054, solution.answer1());
        assertEquals(14314925001L, solution.answer2());
    }

    @Test
    void solveSample() {
        Day11Solver solver = new Day11Solver();
        solver.setInput("sample.txt");
        Solution solution = solver.solve();

        assertEquals(10605, solution.answer1());
        assertEquals(2713310158L, solution.answer2());
    }
}