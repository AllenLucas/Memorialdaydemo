package sxtlal.allenlucas.memorialday;

import android.text.TextUtils;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by AllenLucas on 2016/5/6.
 */
public class RestoreData {
    public static void restoreBridth(String string){
        String jinianri = SPUtils.get(string,"");
        if(!TextUtils.isEmpty(jinianri)){
            List<Data> ps = new Gson().fromJson(jinianri,new TypeToken<List<Data>>(){}.getType());
            MyApplication.list.addAll(ps);
        }
    }
}
