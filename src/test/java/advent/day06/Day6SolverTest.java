package advent.day06;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day6SolverTest {

    @Test
    void solve() {
        Solution solution = new Day6Solver().solve();
        assertEquals(1804, solution.answer1());
        assertEquals(2508, solution.answer2());
    }

    @Test
    void solveSample1() {
        Solution solution = new Day6Solver("mjqjpqmgbljsphdztnvjfqwrcgsmlb").solve();
        assertEquals(7, solution.answer1());
        assertEquals(19, solution.answer2());
    }

    @Test
    void solveSample2() {
        Solution solution = new Day6Solver("bvwbjplbgvbhsrlpgdmjqwftvncz").solve();
        assertEquals(5, solution.answer1());
        assertEquals(23, solution.answer2());
    }

    @Test
    void solveSample3() {
        Solution solution = new Day6Solver("nppdvjthqldpwncqszvftbrmjlhg").solve();
        assertEquals(6, solution.answer1());
        assertEquals(23, solution.answer2());
    }

    @Test
    void solveSample4() {
        Solution solution = new Day6Solver("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solve();
        assertEquals(10, solution.answer1());
        assertEquals(29, solution.answer2());
    }

    @Test
    void solveSample5() {
        Solution solution = new Day6Solver("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solve();
        assertEquals(11, solution.answer1());
        assertEquals(26, solution.answer2());
    }
}