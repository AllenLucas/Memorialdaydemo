package sxtlal.allenlucas.memorialday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.Date;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/2.
 */
public class MemorialActiviaty extends BaseActivity {
    @Bind(R.id.edtv)
    EditText edtv;
    private int year;
    private int month;
    private int day;
    @Bind(R.id.title1)
    LinearLayout title1;
    @Bind(R.id.ok)
    Button ok;
    @Bind(R.id.cancel)
    Button cancel;
    @Bind(R.id.buttommenu)
    LinearLayout buttommenu;
    @Bind(R.id.edtvtv)
    TextView edtvtv;
    @Bind(R.id.edtvtitle)
    LinearLayout edtvtitle;
    @Bind(R.id.time)
    TextView time;
    @Bind(R.id.dp1)
    DatePicker dp1;
    private Date date;
    private Calendar c;
    private String time1;
    private int d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorial_second);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {
        c = Calendar.getInstance();
        date = new Date();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        dp1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                MemorialActiviaty.this.year = year;
                MemorialActiviaty.this.month = month;
                MemorialActiviaty.this.day = day;
                date.setYear(year);
                date.setMonth(month);
                date.setDay(day);
                time1 = date.getYear()+"-"+ (date.getMonth()+1)+"-"+date.getDay();
            }
        });

    }
public void today(String time1){
    SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
    try {
        java.util.Date parse1 = sp.parse(time1);
        Calendar calendar = Calendar.getInstance();
        Date parse2 = new Date(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(parse2);
        long min =  calendar.getTime().getTime()-parse1.getTime();
        d = (int) (min/(1000 * 60 * 60 * 24));
    } catch (ParseException e) {
        e.printStackTrace();
    }

}

    private void initData() {
        Intent intent = getIntent();
        String content = edtv.getText().toString();
        if(content.equals("")){
            Toast.makeText(MemorialActiviaty.this,"标题不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        today(time1);
        intent.putExtra("data", content);
        intent.putExtra("date", date.toString());
        intent.putExtra("time",d+"");
        setResult(RESULT_OK, intent);
        finish();
    }

    @OnClick({R.id.ok, R.id.cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ok:
                initData();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }
}
