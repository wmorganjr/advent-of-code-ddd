package advent.day12;

public interface SearchProblemStatement {
    GridPosition startPosition();

    Iterable<? extends GridPosition> candidatePositions(GridPosition lastPosition);

    boolean isGoalPosition(GridPosition lastPosition);
}
