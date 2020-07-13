package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;
/**
 * @author Mička Petr
 */
public class MaxSizeFilter extends BasicFilter {
    private final long maxSize;

    /**
     *
     * @param paths paths
     * @param maxSize maximal size
     */
    public MaxSizeFilter(List<SearchEntry> paths ,long maxSize) {
        super(paths);
        this.maxSize = maxSize;
    }

    @Override
    public boolean filter(SearchEntry path) {

        return path.getSize()<=maxSize;
    }
}
