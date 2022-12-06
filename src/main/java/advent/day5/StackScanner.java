package advent.day5;

import java.util.Scanner;

final class StackScanner {
    private final Scanner scanner;
    private final int index;

    StackScanner(final Scanner scanner, final int index) {
        this.scanner = scanner;
        this.index = index;
    }

    Stack stack() {
        Stack stack = new Stack();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                return stack;
            }

            // The standard library Scanner trims whitespace at the end of
            // each line. I'm not sure if this can be overridden by
            // configuration, but in any case it's better to be defensive
            // and check that the string is at least long enough to access
            // the character at this position.
            if (line.length() <= index * 4 + 1) {
                continue;
            }

            char crate = line.charAt(index * 4 + 1);
            if (Character.isLetter(crate)) {
                stack.addToBottom(crate);
            }
        }

        return null;
    }
}
