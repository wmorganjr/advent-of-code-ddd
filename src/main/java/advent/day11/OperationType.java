package advent.day11;

public enum OperationType {
    ADDITION,
    MULTIPLICATION;

    public static OperationType parse(final String group) {
        return switch (group) {
            case "+" -> ADDITION;
            case "*" -> MULTIPLICATION;
            default -> null;
        };
    }
}
