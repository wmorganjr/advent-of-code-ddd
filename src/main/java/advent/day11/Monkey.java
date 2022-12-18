package advent.day11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

final class Monkey {
    private final String id;
    private final LinkedList<Item> items;
    private final Operation operation;
    private final MonkeyTest test;
    private int inspections;

    Monkey(final String id, final Item[] items, final Operation operation, final MonkeyTest test) {
        this.id = id;
        this.items = new LinkedList<>(Arrays.asList(items));
        this.operation = operation;
        this.test = test;
        this.inspections = 0;
    }

    void inspectAndThrowAllItems(MonkeyGroup monkeyGroup, final int worryDivisor) {
        ListIterator<Item> listIterator = items.listIterator();

        while (listIterator.hasNext()) {
            Item item = listIterator.next();
            item.inspect(operation);
            inspections++;

            Monkey destMonkey = worryDivisor == 3 ?
                    test.destMonkey(monkeyGroup, item.worryLevelPart1()) :
                    test.destMonkey(monkeyGroup, item.worryLevelPart2());

            listIterator.remove();
            destMonkey.receiveItem(item);
        }
    }

    private void receiveItem(final Item item) {
        receiveItem(item, items);
    }

    private void receiveItem(final Item item, LinkedList<Item> itemList) {
        itemList.add(item);
    }

    String id() {
        return id;
    }

    int inspections() {
        return inspections;
    }

    int testDivisor() {
        return test.condition().modulus();
    }

    void setPossibleDivisors(final int[] possibleDivisors) {
        for (Item item : items) {
            item.setPossibleDivisors(possibleDivisors);
        }
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "id='" + id + '\'' +
                ", items=" + items.size() +
                ", inspections=" + inspections +
                '}';
    }
}
