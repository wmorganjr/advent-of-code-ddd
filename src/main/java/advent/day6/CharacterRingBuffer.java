package advent.day6;

final class CharacterRingBuffer {
    private final char[] chars;
    private final int capacity;
    private final int[] charCounts;
    private int count;

    CharacterRingBuffer(final int capacity) {
        this.chars = new char[capacity];
        this.capacity = capacity;

        // We could make this array smaller by making it only big enough for
        // the characters which are used in the problem, but doing it this
        // way permits us to the skip ASCII math and just index the character
        // counts at their ordinal indexes directly.
        this.charCounts = new int['z' + 1];
        count = 0;
    }

    void add(final char c) {
        int pos = count % capacity;

        // We could guard this statement with a check to isFull(), but
        // it's not necessary for the interface exposed by this class.
        // The effect of ignoring the isFull check is that charCounts[0]
        // is decremented n=bufferSize times before the buffer wraps
        // around and chars[pos] starts to point at real data. But since
        // nothing looks at charCounts[0], it's fine to modify it in this way.
        charCounts[chars[pos]]--;

        charCounts[c]++;
        chars[pos] = c;
        count++;
    }

    boolean isFull() {
        return count >= capacity;
    }

    boolean unique() {
        for (int i = 'a'; i <= 'z'; i++) {
            if (charCounts[i] > 1) {
                return false;
            }
        }

        return true;
    }
}
