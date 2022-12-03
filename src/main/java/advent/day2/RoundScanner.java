package advent.day2;

import java.util.Scanner;

final class RoundScanner {
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
}
