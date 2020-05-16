package homework.TestChainOfRespnsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    private int index;

    public List<Filter> getFilterChain() {
        return filters;
    }

    public void setFilterChain(List<Filter> filterChain) {
        this.filters = filterChain;
    }

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filerChian) {
        if(index == filters.size()) {
            return;
        }
        Filter ff = filters.get(index);
        index ++;
        ff.doFilter(request,response,filerChian);
    }
}
