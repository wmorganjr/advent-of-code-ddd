package advent.day3;

import java.util.Scanner;

final class RucksackScanner {
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
}
