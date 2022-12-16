package advent.day07;

record ChangeDirectoryIn(String directory) implements TerminalOutputLine {
    @Override
    public boolean isChangeDirectoryIn() {
        return true;
    }

    @Override
    public boolean isChangeDirectoryOut() {
        return false;
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
