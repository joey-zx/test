package homework.TestChainOfRespnsibility;

public class StringProcessor {

    private FilterChain filterChain;

    public FilterChain getFilterChain() {
        return filterChain;
    }

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public void doProcess(Request request, Response response) {
        filterChain.doFilter(request, response, filterChain);
    }
}
