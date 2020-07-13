package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * @author Mička Petr
 */

public class FileSizeComparator implements BasicComparator {
    private final BasicComparator nextComparator;

    /**
     *
     * @param nextComparator next comparator
     * creates new comparator
     */
    public FileSizeComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        if((int) (searchEntry.getSize()-t1.getSize()) == 0) {
            return nextComparator.compare(searchEntry, t1);
        }
        return (int) (searchEntry.getSize()-t1.getSize());
    }
}
