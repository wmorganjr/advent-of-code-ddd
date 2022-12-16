package advent.day07;

import java.util.Iterator;
import java.util.LinkedList;

final class DepthFirstSearchIterator implements Iterator<Directory> {
    private final LinkedList<Directory> stack;

    DepthFirstSearchIterator(final Directory root) {
        stack = new LinkedList<>();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return ! stack.isEmpty();
    }

    @Override
    public Directory next() {
        Directory next = stack.pop();

        for (Directory child: next.children()) {
            stack.push(child);
        }

        return next;
    }
}
