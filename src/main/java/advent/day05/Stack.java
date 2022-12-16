package advent.day05;

import java.util.LinkedList;
import java.util.Objects;

final class Stack {
    private final LinkedList<Character> crates = new LinkedList<>();

    void addToBottom(final char crate) {
        crates.offerLast(crate);
    }

    void addToTop(final char crate) {
        crates.offerFirst(crate);
    }

    void addAllToTop(final char[] crates) {
        for (char crate : crates) {
            addToTop(crate);
        }
    }

    char topCrate() {
        return Objects.requireNonNull(crates.peek());
    }

    char pickUpTopCrate() {
        return crates.pop();
    }

    // The crates at the top of the stack will be last in the array.
    // Therefore, they can be properly added to another stack by
    // iterating from 0 and calling addToTop.
    char[] pickUpTopCrates(final int n) {
        char[] crates = new char[n];
        for (int i = 0; i < n; i++) {
            crates[n - i - 1] = pickUpTopCrate();
        }
        return crates;
    }
}
