package advent.day11;

final class Item {
    private long worryLevelPart1;
    private ModularCongruenceSet worryLevelPart2;

    Item(final long worryLevel) {
        this.worryLevelPart1 = worryLevel;
    }

    static Item[] ofStringSplit(final String[] split) {
        Item[] result = new Item[split.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Item.parse(split[i]);
        }

        return result;
    }

    static Item parse(final String s) {
        return new Item(Long.parseLong(s));
    }

    void inspect(final Operation operation) {
        worryLevelPart1 = operation.operate(worryLevelPart1);
        worryLevelPart1 /= 3;

        operation.operate(worryLevelPart2);
    }

    long worryLevelPart1() {
        return worryLevelPart1;
    }

    void setPossibleDivisors(final int[] possibleDivisors) {
        worryLevelPart2 = new ModularCongruenceSet(worryLevelPart1, possibleDivisors);
    }

    ModularCongruenceSet worryLevelPart2() {
        return worryLevelPart2;
    }
}
