package advent.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        Solution solution = new Solver().solve();

        assertEquals(72602, solution.answer1());
        assertEquals(207410, solution.answer2());
    }
}