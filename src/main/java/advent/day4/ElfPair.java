package advent.day4;

import java.util.regex.MatchResult;

record ElfPair(Elf firstElf, Elf secondElf) {
    static ElfPair ofMatchResult(final MatchResult matchResult) {
        return new ElfPair(
                Elf.parse(matchResult.group(1), matchResult.group(2)),
                Elf.parse(matchResult.group(3), matchResult.group(4))
        );
    }

    boolean rangeFullyContained() {
        return firstElf.fullyContainsRange(secondElf) ||
                secondElf.fullyContainsRange(firstElf);
    }

    public boolean rangeOverlaps() {
        return firstElf().overlapsRange(secondElf);
    }
}
