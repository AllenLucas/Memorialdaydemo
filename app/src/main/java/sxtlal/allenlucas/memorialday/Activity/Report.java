package sxtlal.allenlucas.memorialday.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.MainActivity;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/3.
 */
public class Report extends BaseActivity {
    @Bind(R.id.retitle)
    TextView retitle;
    @Bind(R.id.rebuttommune)
    LinearLayout rebuttommune;
    @Bind(R.id.reedtv)
    EditText reedtv;
    @Bind(R.id.rebtn1)
    Button rebtn1;
    @Bind(R.id.rebtn2)
    Button rebtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reprot_second);
        ButterKnife.bind(this);
//        Window window = getWindow();
//        window.setGravity(Gravity.BOTTOM);
    }

    @OnClick({R.id.rebtn1, R.id.rebtn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rebtn1:
                if(TextUtils.isEmpty(reedtv.getText().toString())){
                    Toast.makeText(this,"内容为空",Toast.LENGTH_SHORT).show();
                   return;
                }
                Toast.makeText(this,"已发送",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.rebtn2:
                finish();
                break;
        }
    }
}
