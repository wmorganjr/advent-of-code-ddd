package advent.day13;

import java.util.Iterator;
import java.util.Scanner;

final class PacketValueTokenizer implements Iterator<PacketValueToken> {
    private final Scanner scanner;

    PacketValueTokenizer(final String string) {
        this.scanner = new Scanner(string);
    }

    static PacketValueTokenizer ofCompressedString(final String string) {
        return new PacketValueTokenizer(string
                .replaceAll("[\\[\\]]", " $0 ")
                .replaceAll(",", " "));
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public PacketValueToken next() {
        return PacketValueToken.parse(scanner.next());
    }
}
