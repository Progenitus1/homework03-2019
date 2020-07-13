package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.FileTools;
/**
 * @author Mička Petr
 */
public class FileExtensionComparator implements BasicComparator{
    private final BasicComparator nextComparator;

    /**
     *
     * @param nextComparator next comparator
     */
    public FileExtensionComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {

        String firstExtension = FileTools.fileExtension(searchEntry.getPath());
        System.out.println(searchEntry.toString() + " " + firstExtension);
        String secondExtension = FileTools.fileExtension(t1.getPath());
        System.out.println(t1.toString() + " " + secondExtension);
        if(firstExtension == null && secondExtension == null) {
            return (new FileNameComparator(nextComparator).compare(searchEntry, t1));
        }
        if(firstExtension == null) {
            firstExtension = "";
        }
        if(secondExtension == null) {
            secondExtension = "";
        }
        return firstExtension.compareTo(secondExtension);
    }
}
