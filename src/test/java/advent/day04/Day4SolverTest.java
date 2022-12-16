package advent.day04;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4SolverTest {

    @Test
    void solve() {
        Solution solution = new Day4Solver().solve();

        assertEquals(464, solution.answer1());
        assertEquals(770, solution.answer2());
    }

}