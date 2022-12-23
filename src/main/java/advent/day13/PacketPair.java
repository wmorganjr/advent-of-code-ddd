package advent.day13;

record PacketPair(int index, Packet leftPacket, Packet rightPacket) {
    boolean inRightOrder() {
        assert leftPacket.isList();
        assert rightPacket.isList();

        return leftPacket.compare(rightPacket) < 0;
    }
}
