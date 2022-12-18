package advent.day11;
import java.util.List;

record MonkeyGroup(List<Monkey> monkeys) {
    long monkeyBusiness() {
        long inspectionsA = 0;
        long inspectionsB = 0;

        for (Monkey monkey : monkeys) {
            long inspections = monkey.inspections();
            if (inspections > inspectionsA) {
                inspectionsB = inspectionsA;
                inspectionsA = inspections;
            } else if (inspections > inspectionsB) {
                inspectionsB = inspections;
            }
        }

        return inspectionsA * inspectionsB;
    }

    void doRound(final int worryDivisor) {
        for (Monkey monkey : monkeys) {
            monkey.inspectAndThrowAllItems(this, worryDivisor);
        }
    }

    Monkey findById(final String monkeyId) {
        // Could be O(1).
        return monkeys.stream().filter(monkey -> monkey.id().equals(monkeyId)).findFirst().orElse(null);
    }

    void doRound() {
        doRound(3);
    }
}
