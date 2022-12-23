package advent.day13;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day13SolverTest {

    @Test
    void solve() {
        Solution solution = new Day13Solver().solve();

        assertEquals(5013, solution.answer1());
        assertEquals(25038, solution.answer2());
    }

    @Test
    void solveSample() {
        Day13Solver day13Solver = new Day13Solver();
        day13Solver.setInput("sample.txt");
        Solution solution = day13Solver.solve();

        assertEquals(13, solution.answer1());
        assertEquals(140, solution.answer2());
    }
}
