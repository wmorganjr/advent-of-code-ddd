package advent.day11;

interface Operand {
    Operand OLD_OPERAND = new Operand() {
        @Override
        public long getValue(final long startingWorryValue) {
            return startingWorryValue;
        }

        @Override
        public boolean isConstant() {
            return false;
        }
    };

    class ConstantOperand implements Operand {
        private final long value;

        public ConstantOperand(final long value) {
            this.value = value;
        }

        @Override
        public long getValue(final long startingWorryValue) {
            return value;
        }

        @Override
        public boolean isConstant() {
            return true;
        }

        @Override
        public String toString() {
            return "ConstantOperand{" +
                    "value=" + value +
                    '}';
        }
    }

    static Operand parse(String string) {
        if (string.equals("old")) {
            return OLD_OPERAND;
        } else {
            return new ConstantOperand(Integer.parseInt(string));
        }
    }

    long getValue(long startingWorryValue);

    boolean isConstant();
}
