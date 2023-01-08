package advent.day15;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15SolverTest {
    @Test
    void solve() {
        Solution solution = new Day15Solver().solve();

        assertEquals(5112034, solution.answer1());
        assertEquals(13172087230812L, solution.answer2());
    }

    @Test
    void solveSample() {
        Day15Solver day15Solver = new Day15Solver();
        day15Solver.setSample();
        Solution solution = day15Solver.solve();

        assertEquals(26, solution.answer1());
        assertEquals(56000011, solution.answer2());
    }
}