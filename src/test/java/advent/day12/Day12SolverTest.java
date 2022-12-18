package advent.day12;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day12SolverTest {

    @Test
    void solve() {
        Solution solution = new Day12Solver().solve();

        assertEquals(437, solution.answer1());
        assertEquals(430, solution.answer2());
    }

    @Test
    void solveSample() {
        Day12Solver day12Solver = new Day12Solver();
        day12Solver.setInput("sample.txt");
        Solution solution = day12Solver.solve();

        assertEquals(31, solution.answer1());
        assertEquals(29, solution.answer2());
    }
}