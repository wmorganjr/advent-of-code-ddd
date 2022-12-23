package advent.day14;

import java.util.HashSet;

final class CaveBuilder {
    private final HashSet<GridPosition> rocks = new HashSet<>();
    private int floorOffset = -1;
    private int abyssOffset = -1;

    void addRock(final GridPosition gridPosition) {
        rocks.add(gridPosition);
    }

    void setAbyssOffset(int abyssOffset) {
        this.abyssOffset = abyssOffset;
    }

    void setFloorOffset(int floorOffset) {
        this.floorOffset = floorOffset;
    }

    Cave build() {
        return new Cave(rocks, abyssOffset, floorOffset);
    }
}
