package advent.day2;

import java.util.regex.Pattern;

enum Shape {
    ROCK,
    PAPER,
    SCISSORS;

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

    boolean defeats(Shape o) {
        return switch (this) {
            case ROCK -> o.equals(SCISSORS);
            case PAPER -> o.equals(ROCK);
            case SCISSORS -> o.equals(PAPER);
        };
    }

    Shape shapeLeadingToOutcome(final Outcome desiredOutcome) {
        for (Shape o : values()) {
            if (new Round(o, this).myOutcome().equals(desiredOutcome)) {
                return o;
            }
        }

        return null;
    }
}
