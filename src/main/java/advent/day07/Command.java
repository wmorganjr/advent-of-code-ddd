package advent.day07;

enum Command implements TerminalOutputLine {
    LS,
    CD_ROOT,
    CD_OUT;

    @Override
    public String directory() {
        return null;
    }

    @Override
    public boolean isChangeDirectoryIn() {
        return false;
    }

    @Override
    public boolean isChangeDirectoryOut() {
        return this == CD_OUT;
    }

    @Override
    public boolean isFileListing() {
        return false;
    }

    @Override
    public FileListing file() {
        return null;
    }
}
