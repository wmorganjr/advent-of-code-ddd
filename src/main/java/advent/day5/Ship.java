package advent.day5;

final class Ship {
    private final Stack[] stacks;
    private final CraneMode craneMode;

    Ship(final Stack[] stacks, final CraneMode craneMode) {
        this.stacks = stacks;
        this.craneMode = craneMode;
    }

    String topCrates() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Stack stack : stacks) {
            stringBuilder.append(stack.topCrate());
        }
        return stringBuilder.toString();
    }

    void moveCrates(final Step step) {
        Stack source = stacks[step.src() - 1];
        Stack destination = stacks[step.dest() - 1];

        craneMode.moveCrates(step.count(), source, destination);
    }
}
