package sxtlal.allenlucas.memorialday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
public class MangerActivity extends BaseActivity {
    @Bind(R.id.edtv1)
    EditText edtv1;
    @Bind(R.id.shengridate)
    TextView shengridate;
    @Bind(R.id.autonotif)
    TextView autonotif;
    @Bind(R.id.duanxin)
    TextView duanxin;
    @Bind(R.id.number)
    EditText number;
    @Bind(R.id.phone)
    LinearLayout phone;
    @Bind(R.id.duanxinneirong)
    LinearLayout duanxinneirong;
    @Bind(R.id.ok)
    Button ok;
    @Bind(R.id.cancel)
    Button cancel;
    private int d;
    private String tianshu;
    private String yearshu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manger_second);
        ButterKnife.bind(this);
        nonvisebale();
        duanxin.setVisibility(View.VISIBLE);

    }

    private void nonvisebale() {
        duanxin.setVisibility(View.GONE);
        phone.setVisibility(View.GONE);
        duanxinneirong.setVisibility(View.GONE);
    }

    @OnClick({R.id.shengridate, R.id.autonotif, R.id.duanxin,R.id.ok,R.id.cancel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shengridate:
                newActivity();
                break;
            case R.id.autonotif:
                break;
            case R.id.duanxin:
                duanxin.setVisibility(View.GONE);
                phone.setVisibility(View.VISIBLE);
                duanxinneirong.setVisibility(View.VISIBLE);
                break;
            case R.id.ok:
                initdata();
                break;
            case R.id.cancel:
                finish();
                break;
        }
    }

    private void initdata() {
        Intent intent = getIntent();
        String content = edtv1.getText().toString();
        if(content.equals("")){
            Toast.makeText(MangerActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(shengridate.getText().equals("点击设置生日")){
            Toast.makeText(MangerActivity.this,"生日怎么能不填",Toast.LENGTH_SHORT).show();
            return;
        }
        today(tianshu);
        intent.putExtra("yaershu",yearshu);
        intent.putExtra("dayshu",d+"");
        intent.putExtra("name",content);
        intent.putExtra("shengri",shengridate.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    private void newActivity() {
        Intent intent = new Intent();
        intent.setClass(MangerActivity.this, dialogdate.class);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                shengridate.setText(data.getStringExtra("title"));
                tianshu = data.getStringExtra("dayshu");
                yearshu = data.getStringExtra("yearshu");
            }
        }
    }
    public void today(String tianshu){
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parse1 = sp.parse(tianshu);
            Calendar calendar = Calendar.getInstance();
            Date parse2 = new Date(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            calendar.setTime(parse2);
            long min =  calendar.getTime().getTime()-parse1.getTime();
            d = (int) (min/(1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
