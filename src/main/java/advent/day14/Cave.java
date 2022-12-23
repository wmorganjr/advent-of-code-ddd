package advent.day14;

import java.util.HashSet;

final class Cave {
    private final HashSet<GridPosition> rock;
    private final HashSet<GridPosition> sand;
    private final int abyssDepth;
    private final int floorDepth;

    Cave(final HashSet<GridPosition> rock, int abyssDy, int floorDy) {
        this.rock = new HashSet<>(rock);
        this.sand = new HashSet<>();
        int maxRockDepth = rock.stream().mapToInt(GridPosition::y).max().orElse(-1);
        assert maxRockDepth > 0;

        this.abyssDepth = maxRockDepth + abyssDy;
        this.floorDepth = maxRockDepth + floorDy;
    }

    SandDestination dropSand(final GridPosition gridPosition) {
        GridPosition sandPosition = gridPosition;

        while (true) {
            GridPosition below = sandPosition.below();
            if (below.y() == abyssDepth) {
                return SandDestination.ABYSS;
            }

            if (! blocked(below)) {
                sandPosition = below;
            } else if (! blocked(below.left())) {
                sandPosition = below.left();
            } else if (! blocked(below.right())) {
                sandPosition = below.right();
            } else {
                sand.add(sandPosition);
                return sandPosition;
            }
        }
    }

    private boolean blocked(final GridPosition gridPosition) {
        return gridPosition.y() == floorDepth ||
                rock.contains(gridPosition) ||
                sand.contains(gridPosition);
    }

    long unitsOfSand() {
        return sand.size();
    }
}
