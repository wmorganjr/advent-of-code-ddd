package advent.day11;

import java.util.LinkedList;
import java.util.Scanner;

final class MonkeyGroupScanner {
    private final MonkeyScanner monkeyScanner;
    MonkeyGroupScanner(final Scanner scanner) {
        this.monkeyScanner = new MonkeyScanner(scanner);
    }

    public MonkeyGroup scanMonkeyGroup() {
        LinkedList<Monkey> monkeys = new LinkedList<>();

        while (monkeyScanner.hasNextMonkey()) {
            monkeys.add(monkeyScanner.nextMonkey());
        }

        int[] possibleDivisors = new int[monkeys.size()];
        int i = 0;
        for (Monkey monkey : monkeys) {
            possibleDivisors[i] = monkey.testDivisor();
            i++;
        }

        for (Monkey monkey : monkeys) {
            monkey.setPossibleDivisors(possibleDivisors);
        }

        return new MonkeyGroup(monkeys);
    }
}
