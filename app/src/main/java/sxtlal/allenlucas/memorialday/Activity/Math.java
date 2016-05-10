package sxtlal.allenlucas.memorialday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.R;
import sxtlal.allenlucas.memorialday.Utils.DateUtils;

/**
 * Created by AllenLucas on 2016/5/9.
 */
public class Math extends BaseActivity {
    @Bind(R.id.startday)
    TextView startday;
    @Bind(R.id.endday)
    TextView endday;
    @Bind(R.id.jisuanday)
    TextView jisuanday;
    @Bind(R.id.mathjieguo)
    LinearLayout mathjieguo;
    private String startdayday;
    private String enddayday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_activity);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mathjieguo.setVisibility(View.GONE);
        Calendar calendar = Calendar.getInstance();
        String initdate = calendar.get(Calendar.YEAR)+"年"+calendar.get(Calendar.MONTH)+"月"+ calendar.get(Calendar.DAY_OF_MONTH)+"日";
        startdayday  = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+ calendar.get(Calendar.DAY_OF_MONTH);
        startday.setText(initdate);
    }

    @OnClick({R.id.startday, R.id.endday})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startday:
                Intent intent = new Intent();
                intent.setClass(this,dialogdate.class);
                startActivityForResult(intent,6);
                break;
            case R.id.endday:
                Intent intent1 = new Intent();
                intent1.setClass(this,dialogdate.class);
                startActivityForResult(intent1, 7);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==6){
            if(resultCode == RESULT_OK){
                String startdate = data.getStringExtra("title");
                startdayday = data.getStringExtra("dayshu");
                startday.setText(startdate);
            }
        }
        if(requestCode==7){
            if(resultCode==RESULT_OK){
                String enddate = data.getStringExtra("title");
                enddayday = data.getStringExtra("dayshu");
                endday.setText(enddate);
                Log.e("main", startdayday);
                Log.e("main2",enddayday);
                mathjieguo.setVisibility(View.VISIBLE);
                String jiesuanjieguo = DateUtils.MathDay(startdayday,enddayday);
                jisuanday.setText(jiesuanjieguo);
            }
        }
    }
}
