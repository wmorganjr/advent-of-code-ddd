package advent.day09;

import java.util.regex.MatchResult;

record Motion(Direction direction, int steps) {
    static Motion ofMatchResult(final MatchResult matchResult) {
        Direction direction = Direction.ofString(matchResult.group(1));
        assert direction != null;

        int steps = Integer.parseInt(matchResult.group(2));
        return new Motion(direction, steps);
    }
}
