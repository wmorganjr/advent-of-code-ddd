package advent.day3;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Solver2Test {

    @Test
    void solve() {
        Solution solution = new Day3Solver2().solve();

        assertEquals(7737, solution.answer1());
        assertEquals(2697, solution.answer2());
    }
}