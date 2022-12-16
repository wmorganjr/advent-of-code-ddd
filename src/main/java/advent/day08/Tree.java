package advent.day08;

final class Tree {
    private final int height;

    Tree(final char c) {
        this.height = Integer.parseInt(Character.toString(c));
    }

    static Tree ofCharacter(final char c) {
        return new Tree(c);
    }

    int height() {
        return height;
    }
}
