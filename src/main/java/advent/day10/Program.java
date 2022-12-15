package advent.day10;

import java.util.Scanner;

final class Program {
    private final Scanner scanner;

    Program(final Scanner scanner) {
        this.scanner = scanner;
    }

    boolean hasNextInstruction() {
        return scanner.hasNextLine();
    }

    Instruction nextInstruction() {
        String line = scanner.nextLine();
        if (line.equals("noop")) {
            return Instruction.NOOP;
        } else {
            int argument = Integer.parseInt(line.split(" ")[1]);
            return new Instruction(InstructionType.ADDX, argument);
        }
    }
}
