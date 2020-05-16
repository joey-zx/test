package homework.DateDemo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Person {

}

class Teacher extends Person {

}

public class DateTest {


    public static void main(String[] args) throws Exception {
        List<Person> people = new ArrayList<Person>();

        /* Date date = simpleDateFormat.parse("2000-10-10");*/

        people.add(new Teacher());

      /*  String str = simpleDateFormat.format(date);
        System.out.println(date);
        System.out.println(str);*/
       /* ;
        String string = "2020-3-26 21:15:23";

        //Date date1 = simpleDateFormat.parse(string);

        String string1 = simpleDateFormat.format(new Date());

        System.out.println(string1);*/


    /*   String string = "20-3-13 下午10:02";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        System.out.println(simpleDateFormat.parse(string));*/

        System.out.println(DateUtils.parse("2010/3/26","yyyy/MM/dd"));

        System.out.println(DateUtils.format(new Date(),"yyyy/MM/dd HH:mm:ss"));

    }
}
