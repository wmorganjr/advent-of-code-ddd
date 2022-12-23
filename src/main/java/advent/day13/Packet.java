package advent.day13;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class Packet extends PacketValue {
    private static final String INITIAL_DECODER_PACKET_LINE = "[[2]]";
    private static final String FINAL_DECODER_PACKET_LINE = "[[6]]";
    private final String line;

    Packet(final String line, final List<PacketValue> packetValues) {
        super(-1, packetValues);
        this.line = line;
    }

    Packet(final String line) {
        this(line, Collections.singletonList(PacketPairScanner.parse(line)));
    }

    boolean isInitialDecoderPacket() {
        return line.equals(INITIAL_DECODER_PACKET_LINE);
    }

    boolean isFinalDecoderPacket() {
        return line.equals(FINAL_DECODER_PACKET_LINE);
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packet packet = (Packet) o;
        return Objects.equals(line, packet.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
