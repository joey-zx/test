package StringDemo;


public class StringInternStudyDemo {
    public static void main(String[] args) {
        /*printJdkVersion();
        ;
       testAndPrintResult("ma", "in");
        testAndPrintResult("ab", "c");;*/
/*
        String s1 = new String("java");

        String s2 = "java";

        System.out.println(s1.intern() == s2);/*



       /* String s3 = new String("123");
        s3.intern();
        String s4 = "123";
        System.out.println(s3 == s4);*/

        testAndPrintResult();
    }

    private static void testAndPrintResult() {
        String str3 = new String("ja") + new String("va");
        String str4 = new String("java");
        System.out.println(str3.hashCode());
        System.out.println(str3.intern().hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str3.intern() == str3);
    }

    private static void printJdkVersion() {
        String javaVersion = "java.version";
        System.out.println(javaVersion + ":" + System.getProperty(javaVersion));
    }
}
