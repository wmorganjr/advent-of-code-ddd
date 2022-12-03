package advent.day2;

import java.util.regex.Pattern;

enum Shape {
    ROCK, PAPER, SCISSORS;

    static Shape parseYours(final String word) {
        assert Pattern.matches("^[ABC]$", word);

        return switch (word) {
            case "A" -> ROCK;
            case "B" -> PAPER;
            case "C" -> SCISSORS;
            default -> null;
        };
    }

    static Shape parseMine(final String word) {
        assert Pattern.matches("^[XYZ]$", word);

        return switch (word) {
            case "X" -> ROCK;
            case "Y" -> PAPER;
            case "Z" -> SCISSORS;
            default -> null;
        };
    }

    int score() {
        return switch (this) {
            case ROCK -> 1;
            case PAPER -> 2;
            case SCISSORS -> 3;
        };
    }

    boolean defeats(final Shape o) {
        return switch (this) {
            case ROCK -> o == SCISSORS;
            case PAPER -> o == ROCK;
            case SCISSORS -> o == PAPER;
        };
    }

    Shape shapeLeadingToOutcome(final Outcome desiredOutcome) {
        // Each call to values() instantiates a new array, but there are only
        // nine possible paths through this method (3 outcomes x 3 shapes).
        // If we need to optimize performance, this code could introduce a
        // memoizing cache, or even hard-coded logic.
        for (Shape o : values()) {
            if (new Round(o, this).myOutcome().equals(desiredOutcome)) {
                return o;
            }
        }

        return null;
    }
}
