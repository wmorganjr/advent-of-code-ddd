package advent.day08;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day8SolverTest {

    @Test
    void solve() {
        Solution solution = new Day8Solver().solve();

        assertEquals(1851, solution.answer1());
        assertEquals(574080, solution.answer2());

    }

    @Test
    void solveSample() {
        Solution solution = new Day8Solver("sample.txt").solve();

        assertEquals(21, solution.answer1());
        assertEquals(8, solution.answer2());
    }
}