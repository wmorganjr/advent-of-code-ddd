package advent.day01;

import advent.ScanningLifecycleSolver;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

final class Day1Solver2 extends ScanningLifecycleSolver<Elf> {
    // Putting the comparator on the priority queue is probably better than
    // relying on the behavior of Comparable<Elf>.
    private PriorityQueue<Elf> elves = new PriorityQueue<>(CalorieComparator.INSTANCE);

    @Override
    protected void next(final Elf elf) {
        elves.add(elf);
    }

    @Override
    protected void end() {
        Elf e1 = elves.poll();
        Elf e2 = elves.poll();
        Elf e3 = elves.poll();

        assert e1 != null;
        assert e2 != null;
        assert e3 != null;

        setPart1Solution(e1.totalCalories());
        setPart2Solution(e1.totalCalories() + e2.totalCalories() + e3.totalCalories());
    }

    @Override
    protected ElfScanner domainObjectScanner(final Scanner scanner) {
        return new ElfScanner(scanner);
    }

    public static void main(String[] args) {
        new Day1Solver2().solve();
    }

    private enum CalorieComparator implements Comparator<Elf> {
        INSTANCE;

        @Override
        public int compare(final Elf o1, final Elf o2) {
            return Long.compare(o2.totalCalories(), o1.totalCalories());
        }
    }
}
