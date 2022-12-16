package advent.day04;

final class Elf {
    private final int sectionLow;
    private final int sectionHigh;

    Elf(final int sectionLow, final int sectionHigh) {
        this.sectionLow = sectionLow;
        this.sectionHigh = sectionHigh;
    }

    static Elf parse(final String sectionLow, final String sectionHigh) {
        return new Elf(Integer.parseInt(sectionLow), Integer.parseInt(sectionHigh));
    }

    boolean fullyContainsRange(final Elf o) {
        return sectionLow <= o.sectionLow && sectionHigh >= o.sectionHigh;
    }

    boolean overlapsRange(final Elf o) {
        return (sectionLow >= o.sectionLow && sectionLow <= o.sectionHigh) ||
               (o.sectionLow >= sectionLow && o.sectionLow <= sectionHigh);
    }
}
