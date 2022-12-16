package advent.day06;

final class Device {
    private int position;
    private int firstStartOfPacket;
    private final CharacterRingBuffer charBuffer;

    public Device(final int bufferSize) {
        this.position = 0;
        this.firstStartOfPacket = -1;
        this.charBuffer = new CharacterRingBuffer(bufferSize);
    }

    void stream(final char c) {
        position++;
        charBuffer.add(c);

        if (firstStartOfPacket == -1 && startOfPacket()) {
            firstStartOfPacket = position;
        }
    }

    boolean startOfPacket() {
        return charBuffer.isFull() && charBuffer.unique();
    }

    int position() {
        return position;
    }

    int firstStartOfPacket() {
        assert firstStartOfPacket > 0;

        return firstStartOfPacket;
    }
}
