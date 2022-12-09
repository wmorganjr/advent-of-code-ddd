package advent.day7;

import advent.ScanningLifecycleSolver;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.StreamSupport;

final class Day7Solver extends ScanningLifecycleSolver<TerminalOutputLine> {
    private final String input;

    private final FileSystem fileSystem;

    Day7Solver(final String input) {
        this.input = input;
        this.fileSystem = new FileSystem(70000000);
    }

    Day7Solver() {
        this("input.txt");
    }

    @Override
    protected void next(final TerminalOutputLine terminalOutputLine) {
        if (terminalOutputLine.isChangeDirectoryIn()) {
            fileSystem.changeDirectoryIn(terminalOutputLine.directory());
        } else if (terminalOutputLine.isChangeDirectoryOut()) {
            fileSystem.changeDirectoryOut();
        } else if (terminalOutputLine.isFileListing()) {
            fileSystem.addFile(terminalOutputLine.file());
        }
    }

    @Override
    protected void end() {
        long part1Solution = StreamSupport.stream(fileSystem.spliterator(), false)
                .mapToLong(Directory::totalSize)
                .filter((size) -> size <= 100000)
                .sum();

        setPart1Solution(part1Solution);

        long upgradeSize = 30000000;
        long spaceNeeded = upgradeSize - fileSystem.unusedSpace();

        long part2Solution = StreamSupport.stream(fileSystem.spliterator(), false)
                .mapToLong(Directory::totalSize)
                .filter((size) -> size >= spaceNeeded)
                .min()
                .orElse(0);

        assert part2Solution > 0;

        setPart2Solution(part2Solution);
    }

    @Override
    protected Iterator<TerminalOutputLine> domainObjectScanner(final Scanner scanner) {
        return new TerminalOutputLineScanner(scanner);
    }

    public static void main(String[] args) {
        new Day7Solver(null).solve();
    }

    @Override
    protected Scanner newScanner() {
        InputStream inputStream = getClass().getResourceAsStream(input);
        return new Scanner(Objects.requireNonNull(inputStream));
    }
}
