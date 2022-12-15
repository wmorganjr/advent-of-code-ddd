package advent.day10;

import advent.Solution;
import advent.Solver;
import advent.SolverSupport;

final class Day10Solver extends SolverSupport implements Solver {

    Day10Solver(final String input) {
        setInput(input);
    }

    Day10Solver() {
        this("input.txt");
    }

    @Override
    public Solution solve() {
        Program program = new Program(newScanner());
        CPU cpu = new CPU(program);
        CRT crt = new CRT(cpu);

        int signalStrengthSum = 0;
        while (cpu.isStillRunning()) {
            // The CRT needs to draw before the CPU ticks, because we want to
            // render the pixel in the top-left corner, which means the CRT
            // needs to poll the CPU when the CRT's cycle number is 0 and the
            // CPU's cycle number is 1 and thus scanning the positions 0-2.
            // If we waited to draw the pixel until after the CPU ticked, the
            // CPU would be scanning positions 1-3 and we would the top-left
            // corner would be empty.
            crt.drawPixel();
            cpu.tick();

            if (cpu.matchesCycleCadence(20, 40)) {
                signalStrengthSum += cpu.signalStrength();
            }
        }

        setPart1Solution(signalStrengthSum);
        setPart2Solution(crt.toString());
        return solution();
    }

    public static void main(String[] args) {
        new Day10Solver().solve();
    }
}
