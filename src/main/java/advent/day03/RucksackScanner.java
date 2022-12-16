package advent.day03;

import java.util.Iterator;
import java.util.Scanner;

final class RucksackScanner implements Iterator<Rucksack> {
    private final Scanner scanner;

    RucksackScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    Rucksack nextRucksack() {
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();

        return Rucksack.ofCharArray(chars);
    }

    boolean hasNextRucksack() {
        return scanner.hasNextLine();
    }

    @Override
    public boolean hasNext() {
        return hasNextRucksack();
    }

    @Override
    public Rucksack next() {
        return nextRucksack();
    }
}
