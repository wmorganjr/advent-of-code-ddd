package advent.day05;

import java.util.regex.MatchResult;

record Step(int count, int src, int dest) {
    static Step ofMatchResult(final MatchResult matcher) {
        return new Step(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3))
        );
    }
}
