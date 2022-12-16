package advent.day09;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day9SolverTest {

    @Test
    void solve() {
        Solution solution = new Day9Solver().solve();
        assertEquals(6087, solution.answer1());
        assertEquals(2493, solution.answer2());
    }

    @Test
    void solveSample() {
        Solution solution = new Day9Solver("sample.txt").solve();
        assertEquals(13, solution.answer1());
        assertEquals(1, solution.answer2());
    }

    @Test
    void solveSample2() {
        Solution solution = new Day9Solver("sample2.txt").solve();
        assertEquals(36, solution.answer2());
    }
}