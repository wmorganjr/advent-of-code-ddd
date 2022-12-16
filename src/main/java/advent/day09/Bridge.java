package advent.day09;

import java.util.HashSet;
import java.util.LinkedList;

final class Bridge {
    private final LinkedList<Knot> knots;
    private final HashSet<GridPosition> tailPositions;

    Bridge(final int knotCount) {
        this.knots = new LinkedList<>();

        for (int i = 0; i < knotCount; i++) {
            this.knots.add(new Knot(i, GridPosition.ORIGIN));
        }

        tailPositions = new HashSet<>();
        tailPositions.add(GridPosition.ORIGIN);
    }

    long countPositionsVisitedByTail() {
        return tailPositions.size();
    }

    void moveHead(final Motion motion) {
        for (int i = 0; i < motion.steps(); i++) {
            step(motion.direction());
        }
    }

    private void step(final Direction direction) {
        knots.getFirst().move(direction);

        Knot front = null;
        Knot back = null;

        for (Knot knot : knots) {
            if (front == null) {
                front = knot;
                continue;
            } else if (back == null) {
                back = knot;
            } else {
                front = back;
                back = knot;
            }

            if (front.distanceFrom(back) > 1) {
                back.moveToward(front);
            }
        }

        assert back != null;
        tailPositions.add(back.gridPosition());
    }
}
