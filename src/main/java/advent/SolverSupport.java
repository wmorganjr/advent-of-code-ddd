package advent;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

class SolverSupport {
    protected long part1Solution = 0;
    protected long part2Solution = 0;
    protected String part1SolutionString = "";
    protected String part2SolutionString = "";
    protected boolean stringMode = false;
    private String inputFileName = "input.txt";

    protected void setPart1Solution(final long part1Solution) {
        println(part1Solution);
        this.part1Solution = part1Solution;
    }

    protected void setPart2Solution(final long part2Solution) {
        println(part2Solution);
        this.part2Solution = part2Solution;
    }

    protected void setPart1Solution(final String part1SolutionString) {
        stringMode = true;

        println(part1SolutionString);
        this.part1SolutionString = part1SolutionString;
    }

    protected void setPart2Solution(final String part2SolutionString) {
        stringMode = true;

        println(part2SolutionString);
        this.part2SolutionString = part2SolutionString;
    }

    protected void setInput(String inputFileName) {
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
        if (stringMode) {
            return new Solution(part1SolutionString, part2SolutionString);
        } else {
            return new Solution(part1Solution, part2Solution);
        }
    }
}
