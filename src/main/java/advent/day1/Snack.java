package advent.day1;

record Snack(long calories) {
    static Snack ofString(final String line) {
        return new Snack(Long.parseLong(line));
    }
}
