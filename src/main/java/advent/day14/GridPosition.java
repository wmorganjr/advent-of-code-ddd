package advent.day14;

import java.util.function.Consumer;

record GridPosition(int x, int y) implements SandDestination {
    static GridPosition parse(final String s) {
        String[] split = s.split(",");
        assert split.length == 2;

        return new GridPosition(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    void forEachPositionBetween(final GridPosition o, final Consumer<? super GridPosition> f) {
        int startX = Math.min(x(), o.x());
        int endX = Math.max(x(), o.x());
        int startY = Math.min(y(), o.y());
        int endY = Math.max(y(), o.y());

        if (startY == endY) {
            // Horizontal
            for (int x = startX; x <= endX; x++) {
                f.accept(new GridPosition(x, startY));
            }
        } else {
            // Vertical
            for (int y = startY; y <= endY; y++) {
                f.accept(new GridPosition(startX, y));
            }
        }
    }

    GridPosition below() {
        return new GridPosition(x, y + 1);
    }

    GridPosition left() {
        return new GridPosition(x - 1, y);
    }

    GridPosition right() {
        return new GridPosition(x + 1, y);
    }

    @Override
    public boolean isAbyss() {
        return false;
    }
}
