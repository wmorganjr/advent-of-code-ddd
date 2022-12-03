package advent.day2;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        Solution solution = new Solver().solve();

        assertEquals(11386, solution.answer1());
        assertEquals(13600, solution.answer2());
    }
}