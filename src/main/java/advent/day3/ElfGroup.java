package advent.day3;

import java.util.Objects;

final class ElfGroup {
    private final Rucksack rucksack1;
    private final Rucksack rucksack2;
    private final Rucksack rucksack3;

    ElfGroup(final Rucksack rucksack1, final Rucksack rucksack2, final Rucksack rucksack3) {
        this.rucksack1 = rucksack1;
        this.rucksack2 = rucksack2;
        this.rucksack3 = rucksack3;
    }

    int sumRucksackPriorities() {
        return rucksack1.priority() + rucksack2.priority() + rucksack3.priority();
    }

    int badgePriority() {
        return Objects.requireNonNull(rucksack1.sharedItem(rucksack2, rucksack3)).priority();
    }
}
