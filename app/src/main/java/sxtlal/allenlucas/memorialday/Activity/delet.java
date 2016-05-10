package sxtlal.allenlucas.memorialday.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/9.
 */
public class delet extends BaseActivity {
    @Bind(R.id.ok)
    Button ok;
    @Bind(R.id.cancel2)
    Button cancel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dete_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ok, R.id.cancel2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ok:
                initDete();
                finish();
                break;
            case R.id.cancel2:
                finish();
                break;
        }
    }

    private void initDete() {
        Intent intent =getIntent();
        int position = intent.getIntExtra("position",0);
        intent.putExtra("pos",position);
        setResult(RESULT_OK, intent);
    }
}
