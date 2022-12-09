package advent.day7;

import java.util.Iterator;

final class FileSystem implements Iterable<Directory> {
    private final long totalAvailableSpace;
    private final Directory root;
    private Directory currentDirectory;

    FileSystem(final long totalAvailableSpace) {
        this.totalAvailableSpace = totalAvailableSpace;
        this.root = Directory.root();
        this.currentDirectory = root;
    }

    void changeDirectoryIn(final String directory) {
        currentDirectory = currentDirectory.createChildIfNotExists(directory);
    }

    void changeDirectoryOut() {
        currentDirectory = currentDirectory.parent();
    }

    void addFile(final FileListing fileListing) {
        currentDirectory.addFileIfNotExists(fileListing);
    }

    long unusedSpace() {
        return totalAvailableSpace - root.totalSize();
    }

    @Override
    public Iterator<Directory> iterator() {
        return new DepthFirstSearchIterator(root);
    }
}
