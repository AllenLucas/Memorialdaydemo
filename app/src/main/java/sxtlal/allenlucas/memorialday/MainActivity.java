package sxtlal.allenlucas.memorialday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.Activity.MangerActivity;
import sxtlal.allenlucas.memorialday.Activity.MemorialActiviaty;
import sxtlal.allenlucas.memorialday.Activity.ShareActivity;
import sxtlal.allenlucas.memorialday.fragment.Memorialfragment;
import sxtlal.allenlucas.memorialday.fragment.findfragment;
import sxtlal.allenlucas.memorialday.fragment.managefragment;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.add)
    ImageView add;
    @Bind(R.id.share)
    ImageView share;
    @Bind(R.id.action_bar_title)
    RelativeLayout actionBarTitle;
    @Bind(R.id.memorial)
    ImageView memorial;
    @Bind(R.id.manage)
    ImageView manage;
    @Bind(R.id.find)
    ImageView find;
    @Bind(R.id.bottommenu)
    RelativeLayout bottommenu;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.add1)
    ImageView add1;
    private List<Fragment> list;
    private String content;
    private String date;

    private FragmentManager manager;
    private Memorialfragment memorialfragment;
    private sxtlal.allenlucas.memorialday.fragment.managefragment managefragment;
    private sxtlal.allenlucas.memorialday.fragment.findfragment findfragment;
    private String time;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initFragment();
        manager = getSupportFragmentManager();
        initview();
        initAdapter();
        initListener();
    }

    private void initFragment() {
        memorialfragment = new Memorialfragment();
        managefragment = new managefragment();
        findfragment = new findfragment();
    }

    private void init() {
        setSelected(memorial);
        title.setText("纪念日");
        share.setVisibility(View.VISIBLE);
        add.setVisibility(View.VISIBLE);
        add1.setVisibility(View.INVISIBLE);
    }

    private void initListener() {
        viewpager.addOnPageChangeListener(this);

    }

    private void initAdapter() {
        fragmentAdapter adapter = new fragmentAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(list.size() - 1);
    }

    private void initview() {
        list = new ArrayList<Fragment>();
        list.add(memorialfragment);
        list.add(managefragment);
        list.add(findfragment);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switchSeleted();
        for (int i = 0; i < list.size(); i++) {
            if (0 == position) {
                init();

            }
            if (1 == position) {
                setSelected(manage);
                title.setText("生日管家");
                share.setVisibility(View.INVISIBLE);
                add1.setVisibility(View.VISIBLE);
                add.setVisibility(View.INVISIBLE);
            }
            if (2 == position) {
                setSelected(find);
                title.setText("发现");
                add.setVisibility(View.INVISIBLE);
                add.setVisibility(View.INVISIBLE);
                add1.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setSelected(View view) {
        view.setSelected(true);
    }

    private void switchSeleted() {
        memorial.setSelected(false);
        manage.setSelected(false);
        find.setSelected(false);
    }

    @OnClick({R.id.add, R.id.add1, R.id.share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                startActivityForResult(new Intent(MainActivity.this, MemorialActiviaty.class), 1);
                break;
            case R.id.share:
                startActivity(new Intent(MainActivity.this,ShareActivity.class));
                break;
            case R.id.add1:
                startActivityForResult(new Intent(MainActivity.this, MangerActivity.class), 2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Data bean = new Data();
                content = data.getStringExtra("data");
                date = data.getStringExtra("date");
                time = data.getStringExtra("time");
                Toast.makeText(this, content + "," + date, Toast.LENGTH_SHORT).show();
                bean.setTitle(content);
                bean.setDate(date);
                bean.setTime(time);
                memorialfragment.onSuccess(bean);
            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Data bean = new Data();
                content = data.getStringExtra("name");
                date = data.getStringExtra("shengri") + " " + data.getStringExtra("yaershu") + "年";
                time = data.getStringExtra("dayshu");
                Toast.makeText(this, content + "," + date + "," + time, Toast.LENGTH_SHORT).show();
                bean.setTitle(content);
                bean.setDate(date);
                bean.setTime(time);
                managefragment.onSuccess2(bean);
            }
        }

    }


    @OnClick({R.id.memorial, R.id.manage, R.id.find})
    public void butoomonclick(View view) {
        switch (view.getId()) {
            case R.id.memorial:
                onPageSelected(0);
                viewpager.setCurrentItem(0);
                break;
            case R.id.manage:
                onPageSelected(1);
                viewpager.setCurrentItem(1);
                break;
            case R.id.find:
                onPageSelected(2);
                viewpager.setCurrentItem(2);
                break;
        }
    }
}
