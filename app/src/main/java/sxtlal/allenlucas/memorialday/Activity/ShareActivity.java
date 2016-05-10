package sxtlal.allenlucas.memorialday.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.BaseActivity;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/9.
 */
public class ShareActivity extends BaseActivity {
    @Bind(R.id.qq)
    ImageView qq;
    @Bind(R.id.weibo)
    ImageView weibo;
    @Bind(R.id.pengyouquan)
    ImageView pengyouquan;
    @Bind(R.id.wechat)
    ImageView wechat;
    @Bind(R.id.shoucuang)
    ImageView shoucuang;
    @Bind(R.id.duanxinxi)
    ImageView duanxinxi;
    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window =getWindow();
        window.setGravity(Gravity.BOTTOM);
        setContentView(R.layout.share_activity);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        window.setLayout(getWindowManager().getDefaultDisplay().getWidth() + 32, (int) (getWindowManager().getDefaultDisplay().getHeight()*0.5));
        ButterKnife.bind(this);
    }

    @OnClick({R.id.qq, R.id.weibo, R.id.pengyouquan, R.id.wechat, R.id.shoucuang, R.id.duanxinxi,R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qq:
                toast("qq");
                break;
            case R.id.weibo:
                toast("微博");
                break;
            case R.id.pengyouquan:
                toast("朋友圈");
                break;
            case R.id.wechat:
                toast("微信");
                break;
            case R.id.shoucuang:
                toast("收藏");
                break;
            case R.id.duanxinxi:
                toast("短信息");
                break;
            case R.id.btn:
                finish();
                break;
        }
    }

    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
