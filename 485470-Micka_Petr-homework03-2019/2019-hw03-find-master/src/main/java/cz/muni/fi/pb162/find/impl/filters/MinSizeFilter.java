package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;
/**
 * @author Mička Petr
 */
public class MinSizeFilter extends BasicFilter {
    private final long minSize;

    /**
     *
     * @param paths paths
     * @param minSize minimal size
     */
    public MinSizeFilter(List<SearchEntry> paths ,long minSize) {
        super(paths);
        this.minSize = minSize;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getSize() >= minSize;
    }
}
