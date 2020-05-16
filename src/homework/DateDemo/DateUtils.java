package homework.DateDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    private DateUtils() {}

    public static String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws Exception{
        return new SimpleDateFormat(pattern).parse(dateStr);
    }
}
