package advent.day5;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Solver2Test {

    @Test
    void solve() {
        Solution solution = new Day5Solver2("input.txt").solve();
        assertEquals("JRVNHHCSJ", solution.answer1String());
        assertEquals("GNFBSBJLH", solution.answer2String());
    }

    @Test
    void solveSample() {
        Solution solution = new Day5Solver2("sample.txt").solve();
        assertEquals("CMZ", solution.answer1String());
        assertEquals("MCD", solution.answer2String());
    }
}