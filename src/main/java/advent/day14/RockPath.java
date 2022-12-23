package advent.day14;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

record RockPath(List<GridPosition> points) {
    void forEachPosition(Consumer<? super GridPosition> f) {
        Iterator<GridPosition> a = points.iterator();
        Iterator<GridPosition> b = points.iterator();

        GridPosition start = a.next();
        b.next();

        while (b.hasNext()) {
            GridPosition end = b.next();
            start.forEachPositionBetween(end, f);
            start = end;
        }
    }
}
