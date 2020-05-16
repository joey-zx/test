package homework.TestChainOfRespnsibility;

public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response,FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replace('<','[')
                .replace('>',']'));
        System.out.println("Request----- HTML");
        filterChain.doFilter(request,response,filterChain);
        request.setRequestStr(response.getResponseStr());
        System.out.println("Response ----HTML");
    }
}
