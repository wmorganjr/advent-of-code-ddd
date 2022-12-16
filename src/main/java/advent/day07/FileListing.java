package advent.day07;

public record FileListing(String name, long size) implements TerminalOutputLine {
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
        return false;
    }

    @Override
    public boolean isFileListing() {
        return true;
    }

    @Override
    public FileListing file() {
        return this;
    }
}
