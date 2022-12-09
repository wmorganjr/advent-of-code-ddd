package advent.day7;

public record DirectoryListing(String directory) implements TerminalOutputLine {
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
        return false;
    }

    @Override
    public FileListing file() {
        return null;
    }
}
