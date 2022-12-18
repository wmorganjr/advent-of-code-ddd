package advent.day11;

import java.util.Objects;

final class Condition {
    private final int modulus;

    Condition(int modulus) {
        this.modulus = modulus;
    }

    boolean matches(final long worryLevel) {
        return worryLevel % modulus == 0;
    }

    int modulus() {
        return modulus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Condition) obj;
        return this.modulus == that.modulus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modulus);
    }

    @Override
    public String toString() {
        return "Condition[" +
                "modulus=" + modulus + ']';
    }
}
