package advent.day3;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        Solution solution = new Solver().solve();

        assertEquals(7737, solution.answer1());
        assertEquals(2697, solution.answer2());
    }
}