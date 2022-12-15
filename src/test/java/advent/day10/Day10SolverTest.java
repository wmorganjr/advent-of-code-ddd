package advent.day10;

import advent.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10SolverTest {
    @Test
    void solve() {
        Solution solution = new Day10Solver().solve();
        assertEquals(14780, solution.answer1());

        String expected = """
                ####.#....###..#....####..##..####.#....
                #....#....#..#.#.......#.#..#....#.#....
                ###..#....#..#.#......#..#......#..#....
                #....#....###..#.....#...#.##..#...#....
                #....#....#....#....#....#..#.#....#....
                ####.####.#....####.####..###.####.####.
                """;
        assertEquals(expected, solution.answer2String());
    }

    @Test
    void solveSample() {
        Solution solution = new Day10Solver("sample.txt").solve();
        assertEquals(13140, solution.answer1());

        String expected = """
                ##..##..##..##..##..##..##..##..##..##..
                ###...###...###...###...###...###...###.
                ####....####....####....####....####....
                #####.....#####.....#####.....#####.....
                ######......######......######......####
                #######.......#######.......#######.....
                """;
        assertEquals(expected, solution.answer2String());
    }
}