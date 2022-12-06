package advent.day5;

import java.util.regex.MatchResult;

record Step(int count, int src, int dest) {
    static Step ofMatchResult(final MatchResult matcher) {
        return new Step(
                Integer.parseInt(matcher.group(1)),
                Integer.parseInt(matcher.group(2)),
                Integer.parseInt(matcher.group(3))
        );
    }

    Stack source(Stack[] stacks) {
        return stacks[src - 1];
    }

    Stack destination(Stack[] stacks) {
        return stacks[dest - 1];
    }
}
