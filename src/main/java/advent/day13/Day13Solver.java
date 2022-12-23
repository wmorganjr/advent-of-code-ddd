package advent.day13;

import advent.ScanningLifecycleSolver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

final class Day13Solver extends ScanningLifecycleSolver<PacketPair> {
    private long sumIndexesRightOrder = 0;
    private ArrayList<Packet> packets = new ArrayList<>();

    @Override
    protected void next(final PacketPair packetPair) {
        if (packetPair.inRightOrder()) {
            sumIndexesRightOrder += packetPair.index();
        }

        packets.add(packetPair.leftPacket());
        packets.add(packetPair.rightPacket());
    }

    @Override
    protected void end() {
        setPart1Solution(sumIndexesRightOrder);

        packets.add(new Packet("[[2]]"));
        packets.add(new Packet("[[6]]"));
        packets.sort(PacketValue::compare);

        int i = 0;
        long isInitialDecoderPacket = -1;
        long isFinalDecoderPacket = -1;

        for (Packet p : packets) {
            i++;
            if (p.isInitialDecoderPacket()) {
                isInitialDecoderPacket = i;
            }

            if (p.isFinalDecoderPacket()) {
                isFinalDecoderPacket = i;
            }
        }

        setPart2Solution(isInitialDecoderPacket * isFinalDecoderPacket);
    }

    @Override
    protected Iterator<PacketPair> domainObjectScanner(final Scanner scanner) {
        return new PacketPairScanner(scanner);
    }

    public static void main(String[] args) {
        new Day13Solver().solve();
    }

}
