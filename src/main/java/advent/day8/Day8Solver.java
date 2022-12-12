package advent.day8;

import advent.ScannerFactory;
import advent.Solution;
import advent.Solver;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

final class Day8Solver implements Solver, ScannerFactory {
    private final String input;

    Day8Solver(final String input) {
        this.input = input;
    }

    Day8Solver() {
        this("input.txt");
    }

    @Override
    public Solution solve() {
        ForestScanner forestScanner = new ForestScanner(this);
        Forest forest = forestScanner.scan();
        RadarImage radarImage = new RadarImage(forest);

        for (LineOfSight lineOfSight: forest.linesOfSight()) {
            radarImage.markTreesVisible(lineOfSight);
        }

        long maxScenicScore = 0;

        for (GridPosition gridPosition : radarImage) {
            long scenicScore = radarImage.scenicScore(gridPosition);
            if (scenicScore > maxScenicScore) {
                maxScenicScore = scenicScore;
            }
        }

        return new Solution(radarImage.visibleTreeCount(), maxScenicScore);
    }

    @Override
    public Scanner newScanner() {
        InputStream inputStream = getClass().getResourceAsStream(input);
        return new Scanner(Objects.requireNonNull(inputStream));
    }

    public static void main(String[] args) {
        new Day8Solver().solve();
    }
}
