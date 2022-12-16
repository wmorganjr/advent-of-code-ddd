package advent.day02;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2SolverTest {

    @Test
    void solve() {
        Solution solution = new Day2Solver().solve();

        assertEquals(11386, solution.answer1());
        assertEquals(13600, solution.answer2());
    }
}