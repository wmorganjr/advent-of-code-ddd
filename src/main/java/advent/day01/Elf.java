package advent.day01;

import java.util.List;

final class Elf implements Comparable<Elf> {
    private final List<Snack> snacks;

    Elf(final List<Snack> snacks) {
        this.snacks = snacks;
    }

    long totalCalories() {
        return snacks.stream().mapToLong(Snack::calories).sum();
    }

    @Override
    public int compareTo(final Elf o) {
        return Long.compare(o.totalCalories(), totalCalories());
    }
}
