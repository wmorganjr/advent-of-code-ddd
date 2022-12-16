package advent.day07;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day7SolverTest {

    @Test
    void solve() {
        Solution solution = new Day7Solver().solve();

        assertEquals(1367870, solution.answer1());
        assertEquals(549173, solution.answer2());
    }

    @Test
    void solveSample() {
        Solution solution = new Day7Solver("sample.txt").solve();

        assertEquals(95437, solution.answer1());
        assertEquals(24933642, solution.answer2());
    }
}