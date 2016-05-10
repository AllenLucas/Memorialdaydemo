package sxtlal.allenlucas.memorialday;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AllenLucas on 2016/5/6.
 */
public class MyApplication extends Application {
    public static MyApplication application;
    public static List<Data> list = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        application =this;
    }
}
