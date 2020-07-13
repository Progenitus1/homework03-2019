package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.SortAction;
import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.FSWalkResult;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.SortFactory;

import java.util.List;

/**
 * @author Mička Petr
 */
public class SortActionImpl extends FSWalkResult implements SortAction {
    /**
     * Constructor for class FSWalkResult
     *
     * @param options application optios
     */
    public SortActionImpl(ApplicationOptions options) {
        super(options);
    }

    @Override
    public List<SearchEntry> getDirectories() {
        return null;
    }

    @Override
    public List<SearchEntry> getFiles() {
        return null;
    }

    @Override
    public List<SearchEntry> sorted(List<SearchEntry> entries) {
        ApplicationOptions options = super.getOpts();
        System.out.println(options.getSort());
        BasicComparator comparator = SortFactory.create(options.getSort());
        entries.sort(comparator);
        return entries;
    }
}
