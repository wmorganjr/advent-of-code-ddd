package advent.day03;

final record Item(char type) {
    int priority() {
        if (Character.isLowerCase(type)) {
            return type - 'a' + 1;
        } else {
            return type - 'A' + 27;
        }
    }
}
