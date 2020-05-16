package homework.TestChainOfRespnsibility;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.getRequestStr().replace("草","").replace("你妹","");
        System.out.println("Request---Sensitive");
        chain.doFilter(request,response,chain);
        response.getResponseStr();
        System.out.println("Response---- Sensitive");
    }
}
