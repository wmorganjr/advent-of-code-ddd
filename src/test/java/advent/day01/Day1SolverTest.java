package advent.day01;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1SolverTest {

    @Test
    void solve() {
        Solution solution = new Day1Solver().solve();

        assertEquals(72602, solution.answer1());
        assertEquals(207410, solution.answer2());
    }
}