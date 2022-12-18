package advent.day11;

import java.util.Arrays;

final class ModularCongruenceSet {
    private int[] moduli;
    private ModValue[] mods;

    ModularCongruenceSet(final long initialValue, final int[] possibleDivisors) {
        int maxModulus = Arrays.stream(possibleDivisors).max().orElse(-1);
        assert maxModulus > 0;

        this.moduli = new int[maxModulus + 1];
        this.mods = Arrays.stream(possibleDivisors).boxed().map(d -> ModValue.of(d, initialValue)).toArray(ModValue[]::new);
        for (int i = 0; i < mods.length; i++) {
            this.moduli[mods[i].modulus()] = i;
        }
    }

    void increaseByConstant(long k) {
        for (int i = 0; i < mods.length; i++) {
            mods[i] = mods[i].plus(k);
        }
    }

    void multiplyByConstant(long k) {
        for (int i = 0; i < mods.length; i++) {
            mods[i] = mods[i].times(k);
        }
    }

    void multiplyByModularCongruenceSet(ModularCongruenceSet o) {
        for (int i = 0; i < mods.length; i++) {
            mods[i] = mods[i].times(o.mods[i].value());
        }
    }

    boolean isDivisibleBy(int d) {
        return mods[moduli[d]].value() == 0;
    }
}
