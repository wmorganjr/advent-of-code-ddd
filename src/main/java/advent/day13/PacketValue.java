package advent.day13;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PacketValue {
    private final int integerValue;
    private final List<PacketValue> listValue;

    protected PacketValue(final int integerValue, final List<PacketValue> listValue) {
        this.integerValue = integerValue;
        this.listValue = listValue;
    }

    static PacketValue ofInteger(final int integerValue) {
        assert integerValue >= 0;

        return new PacketValue(integerValue, null);
    }

    static PacketValue ofList(final List<PacketValue> listValue) {
        return new PacketValue(-1, listValue);
    }

    boolean isInteger() {
        return integerValue >= 0;
    }

    boolean isList() {
        return integerValue == -1;
    }

    // Return < 0 if this is less than o, 0 if equal, and > 0 if greater than o
    int compare(PacketValue o) {
        if (isInteger() && o.isInteger()) {
            return Integer.compare(integerValue, o.integerValue);
        }

        if (isList() && o.isList()) {
            Iterator<PacketValue> leftValueIterator = listValue.listIterator();
            Iterator<PacketValue> rightValueIterator = o.listValue.listIterator();

            while (leftValueIterator.hasNext()) {
                if (! rightValueIterator.hasNext()) {
                    return 1;
                }

                PacketValue leftValue = leftValueIterator.next();
                PacketValue rightValue = rightValueIterator.next();

                int comparison = leftValue.compare(rightValue);

                if (comparison != 0) {
                    return comparison;
                }
            }

            return rightValueIterator.hasNext() ? -1 : 0;
        }

        if (isList() && o.isInteger()) {
            return compare(convertToList(o));
        } else {
            return convertToList(this).compare(o);
        }
    }

    private static PacketValue convertToList(final PacketValue packetValue) {
        return ofList(Collections.singletonList(packetValue));
    }

    @Override
    public String toString() {
        return "PacketValue{" +
                "integerValue=" + integerValue +
                ", listValue=" + listValue +
                '}';
    }
}
