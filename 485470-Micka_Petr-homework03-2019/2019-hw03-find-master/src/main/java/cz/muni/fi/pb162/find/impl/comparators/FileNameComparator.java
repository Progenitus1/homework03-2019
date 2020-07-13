package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
/**
 * @author Mička Petr
 */
public class FileNameComparator implements BasicComparator{
    private final BasicComparator nextComparator;

    /**
     *
     * @param nextComparator next comparator
     */
    public FileNameComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        if(searchEntry.getFileName().toString().compareTo(t1.getFileName().toString()) == 0) {
            nextComparator.compare(searchEntry, t1);
        }
        return searchEntry.getFileName().toString().compareTo(t1.getFileName().toString());
    }
}
