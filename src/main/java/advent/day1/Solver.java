package advent.day1;

import advent.Solution;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

final class Solver {
    Solution solve() {
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Solver.class.getResourceAsStream("input.txt")))) {
            ElfScanner elfScanner = new ElfScanner(scanner);

            long maxCalories = 0;
            PriorityQueue<Elf> elves = new PriorityQueue<>();
            while (elfScanner.hasNextElf()) {
                Elf elf = elfScanner.nextElf();
                elves.add(elf);
                if (elf.totalCalories() > maxCalories) {
                    maxCalories = elf.totalCalories();
                }
            }

            System.out.println(maxCalories);

            assert elves.peek() != null;
            System.out.println(elves.peek().totalCalories());

            // This is right. When you get a stream of a PriorityQueue, the first element is
            // the one with the highest priority.
            long sumTop1 = elves.stream().limit(1).mapToLong(Elf::totalCalories).sum();
            System.out.println(sumTop1);

            // This is wrong. Streaming more than one element of a PriorityQueue does not
            // guarantee that you will get the three highest-priority items
            long sumTop3 = elves.stream().limit(3).mapToLong(Elf::totalCalories).sum();
            System.out.println(sumTop3);

            // This is right. Calling poll() on the PriorityQueue shuffles the heap so that
            // the next element popped off the queue will be the element with the highest
            // priority.
            Elf e1 = elves.poll();
            Elf e2 = elves.poll();
            Elf e3 = elves.poll();

            assert e1 != null;
            assert e2 != null;
            assert e3 != null;

            long sumTopThreeCalories = e1.totalCalories() + e2.totalCalories() + e3.totalCalories();
            System.out.println(sumTopThreeCalories);

            return new Solution(maxCalories, sumTopThreeCalories);
        }
    }

    public static void main(String[] args) {
        new Solver().solve();
    }
}
