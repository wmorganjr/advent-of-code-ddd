package advent.day2;

import java.util.Iterator;
import java.util.Scanner;

// TODO this class can't implement Iterator<Round> yet because there are two
//  ways to parse a round: day 1 or day 2. The proper thing to do will be to
//  introduce a tuple class for which this class can be a proper Iterator,
//  but that tuple class does not exist yet.
final class RoundScanner implements Iterator<RoundTuple> {
    private final Scanner scanner;
    private String[] lastScannedWords;

    RoundScanner(final Scanner scanner) {
        this.scanner = scanner;
    }

    Round nextRoundPart1() {
        nextRound();
        return currentRoundPart1();
    }

    Round nextRoundPart2() {
        nextRound();
        return currentRoundPart2();
    }

    Round currentRoundPart1() {
        assert lastScannedWords != null;

        Shape yourShape = Shape.parseYours(lastScannedWords[0]);
        Shape myShape = Shape.parseMine(lastScannedWords[1]);
        return Round.ofPart1(myShape, yourShape);
    }

    Round currentRoundPart2() {
        assert lastScannedWords != null;

        Shape yourShape = Shape.parseYours(lastScannedWords[0]);
        Outcome desiredOutcome = Outcome.parse(lastScannedWords[1]);
        return Round.ofPart2(yourShape, desiredOutcome);
    }

    boolean hasNextRound() {
        return scanner.hasNextLine();
    }

    private void nextRound() {
        lastScannedWords = scanner.nextLine().split(" ");
    }

    @Override
    public boolean hasNext() {
        return hasNextRound();
    }

    @Override
    public RoundTuple next() {
        Round part1Round = nextRoundPart1();
        Round part2Round = currentRoundPart2();
        return new RoundTuple(part1Round, part2Round);
    }
}
