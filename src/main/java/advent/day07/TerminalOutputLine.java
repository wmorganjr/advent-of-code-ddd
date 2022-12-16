package advent.day07;

interface TerminalOutputLine {
    String directory();

    boolean isChangeDirectoryIn();

    boolean isChangeDirectoryOut();

    boolean isFileListing();

    FileListing file();
}
