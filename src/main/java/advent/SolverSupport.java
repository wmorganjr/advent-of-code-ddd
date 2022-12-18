package advent;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class SolverSupport {
    protected long part1Solution = 0;
    protected long part2Solution = 0;
    protected String part1SolutionString = "";
    protected String part2SolutionString = "";

    private Mode mode = Mode.UNKNOWN;
    private String inputFileName = "input.txt";

    protected void setPart1Solution(final long part1Solution) {
        println(part1Solution);
        this.part1Solution = part1Solution;
        updateModeLong();
    }

    protected void setPart2Solution(final long part2Solution) {
        println(part2Solution);
        this.part2Solution = part2Solution;
        updateModeLong();
    }

    protected void setPart1Solution(final String part1SolutionString) {
        println(part1SolutionString);
        this.part1SolutionString = part1SolutionString;
        updateModeString();
    }

    protected void setPart2Solution(final String part2SolutionString) {
        println(part2SolutionString);
        this.part2SolutionString = part2SolutionString;

        updateModeString();
    }

    public void setInput(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    protected void println(Object x) {
        System.out.println(x);
    }

    protected Scanner newScanner() {
        InputStream inputStream = getClass().getResourceAsStream(inputFileName);
        return new Scanner(Objects.requireNonNull(inputStream));
    }

    protected Solution solution() {
        return switch (mode) {
            case LONG_LONG -> new Solution(part1Solution, part2Solution);
            case STRING_STRING -> new Solution(part1SolutionString, part2SolutionString);
            case LONG_STRING -> new Solution(part1Solution, part2SolutionString);
            case STRING_LONG -> new Solution(part1SolutionString, part2Solution);
            case UNKNOWN -> new Solution(
                    part1Solution,
                    part1SolutionString,
                    part2Solution,
                    part2SolutionString
            );
        };
    }

    private void updateModeLong() {
        mode = mode.plusLongAnswer();
    }

    private void updateModeString() {
        mode = mode.plusStringAnswer();
    }

    private enum Mode {
        UNKNOWN,
        LONG_LONG,
        STRING_STRING,
        LONG_STRING,
        STRING_LONG;

        Mode plusLongAnswer() {
            return switch(this) {
                case UNKNOWN, LONG_LONG -> LONG_LONG;
                case STRING_STRING -> STRING_LONG;
                default -> UNKNOWN;
            };
        }

        Mode plusStringAnswer() {
            return switch(this) {
                case UNKNOWN, STRING_STRING -> STRING_STRING;
                case LONG_LONG -> LONG_STRING;
                default -> UNKNOWN;
            };
        }
    }
}
