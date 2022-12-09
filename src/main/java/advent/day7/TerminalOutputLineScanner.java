package advent.day7;

import java.util.Iterator;
import java.util.Scanner;

final class TerminalOutputLineScanner implements Iterator<TerminalOutputLine> {
    private final Scanner scanner;

    TerminalOutputLineScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public TerminalOutputLine next() {
        String line = scanner.nextLine();
        String[] words = line.split(" ");

        if (words[0].equals("$")) {
            if (words[1].equals("ls")) {
                return Command.LS;
            } else if (words[2].equals("/")) {
                return Command.CD_ROOT;
            } else if (words[2].equals("..")) {
                return Command.CD_OUT;
            } else {
                return new ChangeDirectoryIn(words[2]);
            }
        } else if (words[0].equals("dir")) {
            return new DirectoryListing(words[1]);
        } else {
            return new FileListing(words[1], Long.parseLong(words[0]));
        }
    }
}
