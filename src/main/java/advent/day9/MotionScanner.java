package advent.day9;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class MotionScanner implements Iterator<Motion> {
    private final Pattern REGEX = Pattern.compile("([UDLR]) (\\d+)");
    private final Scanner scanner;

    MotionScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public Motion next() {
        Matcher matcher =  REGEX.matcher(scanner.nextLine());
        if (matcher.matches()) {
            return Motion.ofMatchResult(matcher);
        }

        return null;
    }
}
