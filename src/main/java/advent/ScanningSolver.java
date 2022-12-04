package advent;

import java.util.Objects;
import java.util.Scanner;

public abstract class ScanningSolver implements Solver {

    @Override
    public Solution solve() {
        try (Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getResourceAsStream("input.txt")))) {
            return solve(scanner);
        }
    }

    abstract protected Solution solve(Scanner scanner);
}
