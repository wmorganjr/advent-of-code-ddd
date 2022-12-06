package advent;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public abstract class ScanningLifecycleSolver<T> implements Solver {
    private long part1Solution = 0;
    private long part2Solution = 0;

    @Override
    public Solution solve() {
        InputStream inputStream = getClass().getResourceAsStream("input.txt");
        try (Scanner inputScanner = new Scanner(Objects.requireNonNull(inputStream))) {
            Iterator<T> domainObjectScanner = domainObjectScanner(inputScanner);

            start();
            domainObjectScanner.forEachRemaining(this::next);
            end();

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

    protected void println(Object x) {
        System.out.println(x);
    }
}
