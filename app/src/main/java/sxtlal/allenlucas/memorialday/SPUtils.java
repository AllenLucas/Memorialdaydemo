package sxtlal.allenlucas.memorialday;

import android.content.Context;

/**
 * Created by AllenLucas on 2016/5/6.
 */
public class SPUtils {
    public static void save (String key,String value){
        MyApplication.application.getSharedPreferences("save", Context.MODE_PRIVATE).edit().putString(key, value).commit();
    }
    public static String get(String key,String defValue){
        return MyApplication.application.getSharedPreferences("save",Context.MODE_PRIVATE).getString(key,defValue);
    }
}
