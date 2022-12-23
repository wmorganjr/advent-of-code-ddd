package advent.day14;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day14SolverTest {

    @Test
    void solve() {
        Solution solution = new Day14Solver().solve();

        assertEquals(683, solution.answer1());
        assertEquals(28821, solution.answer2());
    }

    @Test
    void solveSample() {
        Day14Solver day14Solver = new Day14Solver();
        day14Solver.setInput("sample.txt");
        Solution solution = day14Solver.solve();

        assertEquals(24, solution.answer1());
        assertEquals(93, solution.answer2());
    }
}