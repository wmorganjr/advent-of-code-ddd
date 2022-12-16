package advent.day06;

import advent.Solution;
import advent.Solver;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

final class Day6Solver implements Solver {
    private final String input;

    Day6Solver() {
        this(null);
    }

    Day6Solver(final String input) {
        this.input = input;
    }

    @Override
    public Solution solve() {
        String input = getInput();

        Device devicePart1 = new Device(4);
        Device devicePart2 = new Device(14);

        for (char c : input.toCharArray()) {
            devicePart1.stream(c);
            devicePart2.stream(c);
        }

        System.out.println(devicePart1.firstStartOfPacket());
        System.out.println(devicePart2.firstStartOfPacket());

        return new Solution(devicePart1.firstStartOfPacket(), devicePart2.firstStartOfPacket());
    }

    private String getInput() {
        if (input != null) {
            return input;
        }

        InputStream inputStream = getClass().getResourceAsStream("input.txt");
        try (Scanner scanner = new Scanner(Objects.requireNonNull(inputStream))) {
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        new Day6Solver().solve();
    }
}
