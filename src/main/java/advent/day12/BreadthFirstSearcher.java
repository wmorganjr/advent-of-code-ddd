package advent.day12;

import java.util.HashMap;
import java.util.HashSet;

final class BreadthFirstSearcher {
    private final SearchProblemStatement searchProblemStatement;
    private final HashMap<GridPosition, Path> shortestPaths;
    private HashSet<Path> frontier;
    private volatile Path solution;

    BreadthFirstSearcher(final SearchProblemStatement searchProblemStatement) {
        this.searchProblemStatement = searchProblemStatement;
        this.solution = null;

        GridPosition start = searchProblemStatement.startPosition();
        Path pathToStart = Path.ofStart(start);

        this.shortestPaths = new HashMap<>();
        this.shortestPaths.put(start, pathToStart);
        this.frontier = new HashSet<>();
        this.frontier.add(pathToStart);
    }

    Path search() {
        while (solution == null && ! frontier.isEmpty()) {
            step();
        }

        return solution;
    }


    void step() {
        HashSet<Path> newFrontier = new HashSet<>();

        for (Path path : frontier) {
            GridPosition lastPosition = path.lastPosition();

            if (searchProblemStatement.isGoalPosition(lastPosition)) {
                setSolution(path);
                break;
            }

            for (GridPosition candidatePosition : searchProblemStatement.candidatePositions(lastPosition)) {
                if (shortestPaths.containsKey(candidatePosition)) {
                    continue;
                }

                Path newPath = path.add(candidatePosition);
                shortestPaths.put(candidatePosition, newPath);
                newFrontier.add(newPath);
            }
        }

        frontier = newFrontier;
    }

    void setSolution(final Path solution) {
        this.solution = solution;
    }
}
