package sxtlal.allenlucas.memorialday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by AllenLucas on 2016/5/5.
 */
public class SplashActivity extends BaseActivity {
    private  boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_splash);

    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },4*1000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus&&isFirst){
            isFirst=false;
            initView();
        }
    }
}
