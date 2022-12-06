package advent.day5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class StepScanner {
    private final Pattern REGEX = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
    private final Scanner scanner;

    StepScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    Step nextStep() {
        do {
            Matcher matcher = REGEX.matcher(scanner.nextLine());
            if (matcher.matches()) {
                return Step.ofMatchResult(matcher);
            }
        } while (scanner.hasNextLine());

        return null;
    }

    boolean hasNextStep() {
        return scanner.hasNextLine();
    }
}