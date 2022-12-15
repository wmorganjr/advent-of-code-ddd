package advent.day10;

final class CPU {
    private final Program program;
    private boolean done;
    private int cycle;
    private int registerX;

    private Instruction nextInstruction;
    private long nextInstructionFinishedCycle;

    CPU(final Program program) {
        this.program = program;

        this.done = false;
        this.cycle = 1;
        this.registerX = 1;

        this.nextInstruction = null;
        this.nextInstructionFinishedCycle = -1;

        loadNextInstruction();
    }

    // Returns whether the program is still running.
    boolean tick() {
        if (done) {
            return false;
        }
        cycle += 1;
        if (instructionFinished()) {
            executeInstruction();
            return loadNextInstruction();
        } else {
            return true;
        }
    }

    boolean isStillRunning() {
        return !done;
    }

    int signalStrength() {
        return cycle * registerX;
    }

    boolean matchesCycleCadence(final int firstCycle, final int subsequentCycleCadence) {
        return cycle == firstCycle ||
                (cycle - firstCycle) % subsequentCycleCadence == 0;
    }

    int registerX() {
        return registerX;
    }

    private boolean instructionFinished() {
        assert nextInstructionFinishedCycle >= cycle;

        return nextInstructionFinishedCycle == cycle;
    }

    private void executeInstruction() {
        if (nextInstruction.instructionType() == InstructionType.ADDX) {
            registerX += nextInstruction.argument();
        }
    }

    private boolean loadNextInstruction() {
        if (program.hasNextInstruction()) {
            nextInstruction = program.nextInstruction();
            nextInstructionFinishedCycle = cycle + nextInstruction.cycles();
            return true;
        } else {
            done = true;
            return false;
        }
    }
}
