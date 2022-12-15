package advent.day10;

public enum InstructionType {
    ADDX,
    NOOP;

    public int cycles() {
        return switch (this) {
            case ADDX -> 2;
            case NOOP -> 1;
        };
    }
}
