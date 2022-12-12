package advent.day8;

import advent.ScannerFactory;

import java.util.Scanner;

final class ForestScanner {
    private ScannerFactory scannerFactory;

    public ForestScanner(final ScannerFactory scannerFactory) {
        this.scannerFactory = scannerFactory;
    }

    public Forest scan() {
        Scanner scanner = scannerFactory.newScanner();
        assert scanner.hasNextLine();
        int width = scanner.nextLine().length();

        // The problem statement doesn't say that the forest will
        // be a square, so we scan twice to get the length value.
        int length = 1;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        Forest forest = new Forest(width, length);

        // Now we scan the individual trees.
        scanner = scannerFactory.newScanner();
        int x = 0;
        int y = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                forest.putTree(x, y, c);
                x++;
            }
            y++;
            x = 0;
        }

        return forest;
    }
}
