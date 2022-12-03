package advent.day1;

import java.util.LinkedList;
import java.util.Scanner;

final class ElfScanner {
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
}
