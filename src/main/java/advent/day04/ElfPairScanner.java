package advent.day04;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ElfPairScanner implements Iterator<ElfPair> {
    private final Pattern REGEX = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
    private final Scanner scanner;

    public ElfPairScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public ElfPair next() {
        Matcher matcher = REGEX.matcher(scanner.nextLine());

        if (matcher.matches()) {
            return ElfPair.ofMatchResult(matcher);
        }

        return null;
    }
}
