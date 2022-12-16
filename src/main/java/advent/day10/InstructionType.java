package advent.day10;

enum InstructionType {
    ADDX,
    NOOP;

    int cycles() {
        return switch (this) {
            case ADDX -> 2;
            case NOOP -> 1;
        };
    }
}
