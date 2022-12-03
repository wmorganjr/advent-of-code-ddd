package advent.day3;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day3SolverTest {

    @Test
    void solve() {
        Solution solution = new Day3Solver().solve();

        assertEquals(7737, solution.answer1());
        assertEquals(2697, solution.answer2());
    }
}