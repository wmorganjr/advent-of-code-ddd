package advent.day07;

import java.util.HashMap;

final class Directory {
    private final String name;
    private final Directory parent;
    private final HashMap<String, Directory> children;
    private final HashMap<String, FileListing> files;

    Directory(final String name, final Directory parent) {
        this.name = name;
        this.parent = parent;
        this.children = new HashMap<>();
        this.files = new HashMap<>();
    }

    static Directory root() {
        return new Directory("/", null);
    }

    Directory createChildIfNotExists(final String name) {
        assert ! children.containsKey(name);
        return children.computeIfAbsent(name, (k) -> new Directory(name, this));
    }

    void addFileIfNotExists(FileListing fileListing) {
        files.putIfAbsent(fileListing.name(), fileListing);
    }

    Directory parent() {
        return parent;
    }

    long totalSize() {
        return files.values().stream().mapToLong(FileListing::size).sum() +
                children.values().stream().mapToLong(Directory::totalSize).sum();
    }

    Iterable<Directory> children() {
        return children.values();
    }
}
