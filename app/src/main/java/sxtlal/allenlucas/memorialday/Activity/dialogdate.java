package sxtlal.allenlucas.memorialday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.Date;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/8.
 */
public class dialogdate extends BaseActivity {
    @Bind(R.id.diatv)
    TextView diatv;
    @Bind(R.id.wancheng)
    Button wancheng;
    @Bind(R.id.dp2)
    DatePicker dp2;
    private int year;
    private int month;
    private int day;
    private Date date;
    private Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_dialog);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        c = Calendar.getInstance();
        date = new Date();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        diatv.setText(year+"年"+ (month+1)+"月"+day+"日");
        dp2.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                dialogdate.this.year = year;
                dialogdate.this.month = month;
                dialogdate.this.day = day;
                date.setYear(year);
                date.setMonth(month);
                date.setDay(day);
                diatv.setText(year + "年" + (month + 1) + "月" + day + "日");
                String time1 = date.getYear()+"-"+ (date.getMonth()+1)+"-"+date.getDay();
            }
        });
    }

    @OnClick(R.id.wancheng)
    public void onClick() {
        Intent intent = getIntent();
        int a = c.get(Calendar.YEAR)-date.getYear();
        intent.putExtra("title", diatv.getText().toString());
        intent.putExtra("dayshu",year + "-" + (month + 1) + "-" + day);
        intent.putExtra("yearshu",a+"");
        setResult(RESULT_OK, intent);
        finish();
    }
}
