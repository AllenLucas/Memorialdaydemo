package sxtlal.allenlucas.memorialday.Utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by AllenLucas on 2016/5/9.
 */
public class DateUtils {


    private static int a;
    private static Date parse1;
    private static Date parse2;

    public static String MathDay(String start,String end){
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        try {
            parse1 = sp.parse(start);
            parse2 = sp.parse(end);
            long min = parse2.getTime()- parse1.getTime();
            a = (int) (min/(1000*60*60*24));
            if(a>0){
                return a+"";
            }else if(a<0){
                return "前后顺序不对";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
