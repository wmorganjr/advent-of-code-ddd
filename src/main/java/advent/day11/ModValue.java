package advent.day11;

record ModValue(int modulus, long value) {
    static ModValue of(final int divisor, final long initialWorry) {
        return new ModValue(divisor, initialWorry % divisor);
    }

    ModValue plus(long k) {
        return new ModValue(modulus, (value + k) % modulus);
    }

    ModValue times(long k) {
        return new ModValue(modulus, (value * k) % modulus);
    }
}
