package advent;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public abstract class ScanningLifecycleSolver<T> implements Solver {
    private long part1Solution = 0;
    private long part2Solution = 0;
    private String part1SolutionString = "";
    private String part2SolutionString = "";
    private boolean stringMode = false;

    @Override
    public Solution solve() {
        start();

        try (Scanner inputScanner = newScanner()) {
            Iterator<T> domainObjectScanner = domainObjectScanner(inputScanner);
            domainObjectScanner.forEachRemaining(this::next);
        }

        end();

        if (stringMode) {
            return new Solution(part1SolutionString, part2SolutionString);
        } else {
            return new Solution(part1Solution, part2Solution);
        }
    }

    protected void start() {}

    protected void end() {}

    protected abstract void next(final T domainObject);

    protected abstract Iterator<T> domainObjectScanner(final Scanner scanner);

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

    protected void println(Object x) {
        System.out.println(x);
    }

    protected Scanner newScanner() {
        InputStream inputStream = getClass().getResourceAsStream("input.txt");
        return new Scanner(Objects.requireNonNull(inputStream));
    }
}
