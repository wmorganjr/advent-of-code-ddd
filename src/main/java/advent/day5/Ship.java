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
        craneMode.moveCrates(step.count(), step.source(stacks), step.destination(stacks));
    }
}
