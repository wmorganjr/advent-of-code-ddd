package advent.day13;

interface PacketValueToken {
    PacketValueTokenType type();
    int value();

    static PacketValueToken parse(final String next) {
        return switch (next) {
            case "[" -> OpenList.INSTANCE;
            case "]" -> CloseParen.INSTANCE;
            default -> IntegerToken.parse(next);
        };
    }

    enum OpenList implements PacketValueToken {
        INSTANCE;

        @Override
        public PacketValueTokenType type() {
            return PacketValueTokenType.OPEN_LIST;
        }

        @Override
        public int value() {
            return -1;
        }

        @Override
        public String toString() {
            return "OpenParen{}";
        }
    }

    enum CloseParen implements PacketValueToken {
        INSTANCE;

        @Override
        public PacketValueTokenType type() {
            return PacketValueTokenType.CLOSE_LIST;
        }

        @Override
        public int value() {
            return -1;
        }

        @Override
        public String toString() {
            return "CloseParen{}";
        }
    }
}
