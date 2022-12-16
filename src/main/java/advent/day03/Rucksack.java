package advent.day03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

final class Rucksack {
    private final Set<Item> allItems;
    private final Compartment firstCompartment;
    private final Compartment secondCompartment;

    Rucksack(final Compartment firstCompartment, final Compartment secondCompartment) {
        this.firstCompartment = firstCompartment;
        this.secondCompartment = secondCompartment;

        allItems = new HashSet<>();
        allItems.addAll(firstCompartment.items());
        allItems.addAll(secondCompartment.items());
    }

    static Rucksack ofCharArray(final char[] chars) {
        Compartment firstCompartment = Compartment.ofSlice(chars, 0, chars.length / 2);
        Compartment secondCompartment = Compartment.ofSlice(chars, chars.length / 2, chars.length / 2);
        return new Rucksack(firstCompartment, secondCompartment);
    }

    int priority() {
        return Objects.requireNonNull(firstCompartment.sharedItem(secondCompartment)).priority();
    }

    Item sharedItem(Rucksack o1, Rucksack o2) {
        for (Item item : allItems) {
            if (o1.allItems.contains(item) && o2.allItems.contains(item)) {
                return item;
            }
        }

        return null;
    }
}
