package advent.day12;

import java.util.Arrays;

final class Heightmap {
    private final int[][] heights;
    private final int width;
    private final int length;
    private final GridPosition start;
    private final GridPosition end;

    Heightmap(final int[][] heights, final int width, final int length, final GridPosition start, final GridPosition end) {
        this.heights = heights;
        this.width = width;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    static Heightmap ofCharArrays(char[][] chars) {
        int length = chars.length;
        assert length > 0;
        int width = chars[0].length;
        int[][] heights = new int[length][width];
        GridPosition start = null, end = null;

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                char c = chars[y][x];
                if (c == 'S') {
                    start = new GridPosition(x, y);
                    c = 'a';
                } else if (c == 'E') {
                    end = new GridPosition(x, y);
                    c = 'z';
                }
                heights[y][x] = c - 'a';
            }
        }

        assert start != null;
        assert end != null;

        return new Heightmap(heights, width, length, start, end);
    }

    int height(GridPosition gridPosition) {
        return heights[gridPosition.y()][gridPosition.x()];
    }

    private boolean isOnMap(final GridPosition destination) {
        return destination.y() >= 0 && destination.y() < length &&
                destination.x() >= 0 && destination.x() < width;
    }

    private boolean climbingGearRequired(final GridPosition source, final GridPosition destination) {
        return height(destination) - 1 > height(source);
    }

    SearchProblemStatement part1ProblemStatement() {
        return new Part1ProblemStatement();
    }

    SearchProblemStatement part2ProblemStatement() {
        return new Part2ProblemStatement();
    }

    private class Part1ProblemStatement implements SearchProblemStatement {
        @Override
        public GridPosition startPosition() {
            return start;
        }

        @Override
        public Iterable<? extends GridPosition> candidatePositions(final GridPosition lastPosition) {
            return () -> Arrays.stream(lastPosition.adjacentPositions()).filter(position -> isOnMap(position) &&
                    ! climbingGearRequired(lastPosition, position)).iterator();
        }

        @Override
        public boolean isGoalPosition(final GridPosition lastPosition) {
            return end.equals(lastPosition);
        }
    }

    private class Part2ProblemStatement implements SearchProblemStatement {
        @Override
        public GridPosition startPosition() {
            return end;
        }

        @Override
        public Iterable<? extends GridPosition> candidatePositions(final GridPosition lastPosition) {
            return () -> Arrays.stream(lastPosition.adjacentPositions()).filter(position -> isOnMap(position) &&
                    ! climbingGearRequired(position, lastPosition)).iterator();
        }

        @Override
        public boolean isGoalPosition(final GridPosition lastPosition) {
            return height(lastPosition) == 0;
        }
    }
}
