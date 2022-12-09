package advent.day7;

interface TerminalOutputLine {
    String directory();

    boolean isChangeDirectoryIn();

    boolean isChangeDirectoryOut();

    boolean isFileListing();

    FileListing file();
}
