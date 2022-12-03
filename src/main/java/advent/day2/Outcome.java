package advent.day2;

import java.util.regex.Pattern;

enum Outcome {
    LOSS, DRAW, WIN;

    static Outcome parse(final String word) {
        assert Pattern.matches("^[XYZ]$", word);

        return switch (word) {
            case "X" -> LOSS;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> null;
        };
    }

    int score() {
        return switch (this) {
            case LOSS -> 0;
            case DRAW -> 3;
            case WIN -> 6;
        };
    }
}
