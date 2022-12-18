package advent.day12;

import advent.ScannerFactory;

import java.util.ArrayList;
import java.util.Scanner;

final class HeightmapScanner {
    private final ScannerFactory scannerFactory;

    HeightmapScanner(final ScannerFactory scannerFactory) {
        this.scannerFactory = scannerFactory;
    }

    Heightmap scan() {
        Scanner scanner = scannerFactory.newScanner();

        assert scanner.hasNextLine();
        String firstLine = scanner.nextLine();
        int width = firstLine.length();

        int length = 1;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            length++;
        }

        char[][] chars = new char[length][width];

        scanner = scannerFactory.newScanner();
        int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            chars[i] = line.toCharArray();
            i++;
        }

        return Heightmap.ofCharArrays(chars);
    }
}
