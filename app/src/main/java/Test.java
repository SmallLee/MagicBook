import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 描述：
 *
 * @author Create by lxn on 2019/1/21
 * @see
 * @since
 * @deprecated
 */
public class Test {
    static String s1 = "2019-01-21 11:55:24";
    static String s2 = "2019-01-21 11:56:24";
    public final static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        long timePassed = getTimePassed(s1, s2);
        System.out.println(timePassed);
    }

    public static long getTimePassed(String startTime,String endTime) {
        try {
            long t1 = sDateFormat.parse(startTime).getTime();
            long t2 = sDateFormat.parse(endTime).getTime();
            return t2 - t1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
