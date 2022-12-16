package advent.day03;

import java.util.Iterator;

final class ElfGroupScanner implements Iterator<ElfGroup> {
    private final RucksackScanner rucksackScanner;

    ElfGroupScanner(final RucksackScanner rucksackScanner) {
        this.rucksackScanner = rucksackScanner;
    }

    ElfGroup nextElfGroup() {
        Rucksack rucksack1 = rucksackScanner.nextRucksack();
        Rucksack rucksack2 = rucksackScanner.nextRucksack();
        Rucksack rucksack3 = rucksackScanner.nextRucksack();

        return new ElfGroup(rucksack1, rucksack2, rucksack3);
    }

    boolean hasNextElfGroup() {
        return rucksackScanner.hasNextRucksack();
    }

    @Override
    public boolean hasNext() {
        return hasNextElfGroup();
    }

    @Override
    public ElfGroup next() {
        return nextElfGroup();
    }
}
