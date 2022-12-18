package advent.day11;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class MonkeyScanner {
    // These patterns assume each monkey identifier is a single digit.
    private static final Pattern ID_REGEX = Pattern.compile(" *Monkey (\\d):");
    private static final Pattern ITEMS_REGEX = Pattern.compile(" *Starting items: (.*)");
    private static final Pattern OPERATION_REGEX = Pattern.compile(" *Operation: (.*)");
    private static final Pattern TEST_REGEX = Pattern.compile(" *Test: divisible by (\\d+)");
    private static final Pattern TRUE_REGEX = Pattern.compile(" *If true: throw to monkey (\\d)");
    private static final Pattern FALSE_REGEX = Pattern.compile(" *If false: throw to monkey (\\d)");
    private final Scanner scanner;

    MonkeyScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    boolean hasNextMonkey() {
        return scanner.hasNextLine();
    }

    Monkey nextMonkey() {
        String idLine = scanner.nextLine();
        String staringItemsLine = scanner.nextLine();
        String operationLine = scanner.nextLine();
        String testLine = scanner.nextLine();
        String trueLine = scanner.nextLine();
        String falseLine = scanner.nextLine();
        String blankLine = scanner.hasNextLine() ? scanner.nextLine() : "";

        String id = parseId(idLine);
        assert id != null;

        Item[] items = parseItems(staringItemsLine);
        assert items != null;

        Operation operation = parseOperation(operationLine);
        assert operation != null;

        Condition condition = parseTestCondition(testLine);
        String trueId = parseId(trueLine);
        String falseId = parseId(falseLine);

        MonkeyTest test = new MonkeyTest(condition, trueId, falseId);

        return new Monkey(
                id,
                items,
                operation,
                test
        );
    }

    private String parseId(final String idLine) {
        Matcher matcher = ID_REGEX.matcher(idLine);
        Matcher matcher2 = TRUE_REGEX.matcher(idLine);
        Matcher matcher3 = FALSE_REGEX.matcher(idLine);
        if (matcher.matches()) {
            return matcher.group(1);
        } else if (matcher2.matches()){
            return matcher2.group(1);
        } else if (matcher3.matches()){
            return matcher3.group(1);
        } else {
            return null;
        }
    }

    private Item[] parseItems(final String staringItemsLine) {
        Matcher matcher = ITEMS_REGEX.matcher(staringItemsLine);
        if (matcher.matches()) {
            return Item.ofStringSplit(matcher.group(1).split(", "));
        } else {
            return null;
        }
    }

    private Operation parseOperation(final String operationLine) {
        Matcher matcher = OPERATION_REGEX.matcher(operationLine);
        if (matcher.matches()) {
            return Operation.parse(matcher.group(1));
        } else {
            return null;
        }
    }

    private Condition parseTestCondition(final String divisibilityModulus) {
        Matcher matcher = TEST_REGEX.matcher(divisibilityModulus);
        if (matcher.matches()) {
            return new Condition(Integer.parseInt(matcher.group(1)));
        } else {
            return null;
        }
    }
}
