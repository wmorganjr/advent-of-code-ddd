package advent.day11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

record Operation(OperationType operationType, Operand operand) {
    private static final Pattern REGEX = Pattern.compile("new = old (.) (.*)");

    static Operation parse(final String string) {
        Matcher matcher = REGEX.matcher(string);
        if (matcher.matches()) {
            OperationType operationType = OperationType.parse(matcher.group(1));
            Operand operand = Operand.parse(matcher.group(2));
            return new Operation(operationType, operand);
        } else {
            return null;
        }
    }

    long operate(final long startingWorryLevel) {
        return switch (operationType) {
            case ADDITION -> startingWorryLevel + operand.getValue(startingWorryLevel);
            case MULTIPLICATION -> startingWorryLevel * operand.getValue(startingWorryLevel);
        };
    }

    void operate(final ModularCongruenceSet worryLevel) {
        switch (operationType) {
            case ADDITION -> worryLevel.increaseByConstant(operand.getValue(0));
            case MULTIPLICATION -> {
                if (operand.isConstant()) {
                    worryLevel.multiplyByConstant(operand.getValue(0));
                } else {
                    worryLevel.multiplyByModularCongruenceSet(worryLevel);
                }
            }
        }
    }
}
