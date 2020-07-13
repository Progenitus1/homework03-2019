package cz.muni.fi.pb162.find.impl;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.filesystem.DirEntry;
import cz.muni.fi.pb162.find.filesystem.FSWalkResult;
import cz.muni.fi.pb162.find.filesystem.FileEntry;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * @author Mička Petr
 */
public class FSWalkResultImpl extends FSWalkResult {
    private final List<SearchEntry> directories;
    private final List<SearchEntry> files;

    /**
     *
     * @param options application options
     */
    public FSWalkResultImpl(ApplicationOptions options) {
        super(options);
        directories = new ArrayList<>();
        files = new ArrayList<>();
    }

    @Override
    public List<SearchEntry> getDirectories() {
        return directories;
    }

    @Override
    public List<SearchEntry> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);
        SearchEntry searchEntry = new FileEntry(file);
        searchEntry.setSize(file.toFile().length());
        files.add(searchEntry);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException {
        Objects.requireNonNull(dir);
        if (exc != null) {
            throw exc;
        }
        directories.add(new DirEntry(dir));
        return FileVisitResult.CONTINUE;
    }
}
