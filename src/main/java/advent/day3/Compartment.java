package advent.day3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class Compartment {
    private final Set<Item> items;

    Compartment(final Set<Item> items) {
        this.items = items;
    }

    static Compartment ofSlice(final char[] chars, final int start, final int count) {
        HashSet<Item> items = new HashSet<>();

        for (int i = 0; i < count; i++) {
            items.add(new Item(chars[start + i]));
        }

        return new Compartment(items);
    }

    Item sharedItem(Compartment o) {
        for (Item item : items) {
            if (o.items.contains(item)) {
                return item;
            }
        }

        return null;
    }

    Set<Item> items() {
        return Collections.unmodifiableSet(items);
    }
}
