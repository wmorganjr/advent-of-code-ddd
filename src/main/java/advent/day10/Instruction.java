package advent.day10;

record Instruction(InstructionType instructionType, int argument) {
    static final Instruction NOOP = new Instruction(InstructionType.NOOP, 0);

    int cycles() {
        return instructionType.cycles();
    }
}
