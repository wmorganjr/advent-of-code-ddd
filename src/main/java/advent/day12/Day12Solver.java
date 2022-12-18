package advent.day12;

import advent.ScannerFactory;
import advent.Solution;
import advent.Solver;
import advent.SolverSupport;

import java.util.Scanner;

final class Day12Solver extends SolverSupport implements Solver, ScannerFactory {
    @Override
    public Solution solve() {
        Heightmap heightmap = new HeightmapScanner(this).scan();

        BreadthFirstSearcher bfs = new BreadthFirstSearcher(heightmap.part1ProblemStatement());
        Path result = bfs.search();
        setPart1Solution(result.steps());

        bfs = new BreadthFirstSearcher(heightmap.part2ProblemStatement());
        result = bfs.search();
        setPart2Solution(result.steps());

        return solution();
    }

    public static void main(String[] args) {
        Day12Solver day12Solver = new Day12Solver();
        day12Solver.solve();
    }

    @Override
    public Scanner newScanner() {
        return super.newScanner();
    }
}
