package advent.day10;

final class CRT {
    private final CPU cpu;
    private final char[][] screen;
    private int cycle;

    CRT(final CPU cpu) {
        this.cpu = cpu;
        this.screen = new char[6][40];
        this.cycle = 0;
    }

    void drawPixel() {
        if (cycle < 240) {
            int vert = cycle / 40;
            int hoz = cycle % 40;

            screen[vert][hoz] = pixel(hoz);

            cycle++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars: screen) {
            stringBuilder.append(chars);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private char pixel(int hoz) {
        return Math.abs(cpu.registerX() - hoz) < 2 ? '#' : '.';
    }
}
