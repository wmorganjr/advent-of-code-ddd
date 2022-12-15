package advent;

import java.util.Iterator;
import java.util.Scanner;

public abstract class ScanningLifecycleSolver<T> extends SolverSupport implements Solver {

    @Override
    public Solution solve() {
        start();

        try (Scanner inputScanner = newScanner()) {
            Iterator<T> domainObjectScanner = domainObjectScanner(inputScanner);
            domainObjectScanner.forEachRemaining(this::next);
        }

        end();

        return solution();
    }

    protected void start() {}

    protected void end() {}

    protected abstract void next(final T domainObject);

    protected abstract Iterator<T> domainObjectScanner(final Scanner scanner);

}
