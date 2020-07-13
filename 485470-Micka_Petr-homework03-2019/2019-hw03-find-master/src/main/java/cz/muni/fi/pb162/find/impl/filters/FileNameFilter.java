package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;
/**
 * @author Mička Petr
 */
public class FileNameFilter extends BasicFilter {
    private final String regex;

    /**
     *
     * @param paths paths
     * @param regex string that we will compare to
     */
    public FileNameFilter(List<SearchEntry> paths ,String regex) {
        super(paths);
        this.regex = regex;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return regex.matches(path.getFileName().toString()) || path.getFileName().toString().matches(regex);
    }
}
