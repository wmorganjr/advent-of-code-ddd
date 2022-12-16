package advent.day05;

import advent.ScannerFactory;

import java.util.Scanner;

final class ShipScanner {
    private final ScannerFactory scannerFactory;

    ShipScanner(final ScannerFactory scannerProvider) {
        this.scannerFactory = scannerProvider;
    }

    Ship scan(final CraneMode craneMode) {
        int stackCount;

        try (Scanner scanner = newScanner()) {
            StackCountScanner stackCountScanner = new StackCountScanner(scanner);
            stackCount = stackCountScanner.stackCount();
        }

        assert stackCount > 0;
        return new Ship(scanStacks(stackCount), craneMode);
    }

    private Stack[] scanStacks(final int stackCount) {
        Stack[] stacks = new Stack[stackCount];

        for (int i = 0; i < stackCount; i++) {
            try (Scanner scanner = newScanner()) {
                StackScanner stackScanner = new StackScanner(scanner, i);
                stacks[i] = stackScanner.stack();
            }
        }

        return stacks;
    }

    private Scanner newScanner() {
        return scannerFactory.newScanner();
    }
}
