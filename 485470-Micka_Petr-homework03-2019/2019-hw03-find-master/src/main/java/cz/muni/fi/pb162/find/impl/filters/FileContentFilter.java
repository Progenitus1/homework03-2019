package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * @author Mička Petr
 */
public class FileContentFilter extends BasicFilter {
    private final String regex;

    /**
     *
     * @param paths paths
     * @param regex string that we will compare with
     */
    public FileContentFilter(List<SearchEntry> paths,String regex) {
        super(paths);
        this.regex = regex;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return false;
    }
}
