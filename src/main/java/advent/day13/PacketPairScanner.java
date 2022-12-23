package advent.day13;

import java.util.*;

final class PacketPairScanner implements Iterator<PacketPair> {
    private int i;
    private final Scanner scanner;

    PacketPairScanner(final Scanner scanner) {
        this.i = 0;
        this.scanner = scanner;
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    @Override
    public PacketPair next() {
        String leftPacketLine = scanner.nextLine();
        String rightPacketLine = scanner.nextLine();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        i++;
        return new PacketPair(i, parse(leftPacketLine), parse(rightPacketLine));
    }

    static Packet parse(final String packetLine) {
        PacketValueTokenizer packetValueTokenizer = PacketValueTokenizer.ofCompressedString(packetLine);

        LinkedList<LinkedList<PacketValue>> packetValueListStack = new LinkedList<>();
        packetValueListStack.add(new LinkedList<>());

        while (packetValueTokenizer.hasNext()) {
            PacketValueToken packetValueToken = packetValueTokenizer.next();

            switch (packetValueToken.type()) {
                case OPEN_LIST -> {
                    LinkedList<PacketValue> list = new LinkedList<>();
                    Objects.requireNonNull(packetValueListStack.peek()).add(PacketValue.ofList(list));
                    packetValueListStack.push(list);
                }
                case CLOSE_LIST -> packetValueListStack.pop();
                case INTEGER -> Objects.requireNonNull(packetValueListStack.peek()).add(PacketValue.ofInteger(packetValueToken.value()));
            }
        }

        PacketValue pv = packetValueListStack.pop().pop();

        return new Packet(packetLine, Collections.singletonList(pv));
    }
}
