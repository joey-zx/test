package homework.TestChainOfRespnsibility;

public class Test {

    public static void main(String[] args) {
        String str = "我爱:) <script> 草 你妹，努力学习java";

        StringProcessor sp = new StringProcessor();

        Request request = new Request();
        request.setRequestStr(str);
        Response response = new Response();
        request.setRequestStr("Response");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter())
                .addFilter(new SensitiveFilter());

        sp.setFilterChain(filterChain);

       sp.doProcess(request,response);
        System.out.println();

    }

}
