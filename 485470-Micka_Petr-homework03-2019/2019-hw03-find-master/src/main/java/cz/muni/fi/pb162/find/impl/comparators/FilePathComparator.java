package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Mička Petr
 */
public class FilePathComparator implements BasicComparator {
    private final BasicComparator nextComparator;

    /**
     * creates new comparator
     */
    public FilePathComparator() {
        this.nextComparator = null;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        return searchEntry.getPath().toString().compareTo(t1.getPath().toString());
    }
}
