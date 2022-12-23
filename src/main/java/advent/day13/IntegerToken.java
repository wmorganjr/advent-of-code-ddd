package advent.day13;

record IntegerToken(int value) implements PacketValueToken {
    static IntegerToken parse(final String value) {
        return new IntegerToken(Integer.parseInt(value));
    }

    @Override
    public PacketValueTokenType type() {
        return PacketValueTokenType.INTEGER;
    }

    @Override
    public int value() {
        return value;
    }
}
