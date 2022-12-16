package advent.day01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

final class ElfScanner implements Iterator<Elf> {
    private final Scanner scanner;

    ElfScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    Elf nextElf() {
        LinkedList<Snack> snacks = new LinkedList<>();
        while (true) {
            // Handles the very last line, since the input doesn't end
            // with a blank line.
            String line = scanner.hasNextLine() ? scanner.nextLine() : "";
            if (line.isBlank()) {
                break;
            }

            snacks.add(Snack.ofString(line));
        }

        return new Elf(snacks);
    }

    boolean hasNextElf() {
        return scanner.hasNextLine();
    }

    @Override
    public boolean hasNext() {
        return hasNextElf();
    }

    @Override
    public Elf next() {
        return nextElf();
    }
}
