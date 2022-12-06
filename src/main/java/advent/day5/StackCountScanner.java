package advent.day5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StackCountScanner {
    private final Pattern REGEX = Pattern.compile("[ \\d]+ (\\d+)");
    private final Scanner scanner;

    StackCountScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    int stackCount() {
        while (scanner.hasNextLine()) {
            Matcher matcher = REGEX.matcher(scanner.nextLine());
            if (matcher.matches()) {
                return Integer.parseInt(matcher.group(1));
            }
        }

        return -1;
    }
}
