package sxtlal.allenlucas.memorialday.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sxtlal.allenlucas.memorialday.Activity.delet;
import sxtlal.allenlucas.memorialday.Activity.dialogdate;
import sxtlal.allenlucas.memorialday.Adapter.CardViewAdapter;
import sxtlal.allenlucas.memorialday.Data;
import sxtlal.allenlucas.memorialday.MyApplication;
import sxtlal.allenlucas.memorialday.R;
import sxtlal.allenlucas.memorialday.RestoreData;
import sxtlal.allenlucas.memorialday.SPUtils;
import sxtlal.allenlucas.memorialday.Utils.DateUtils;

/**
 * Created by AllenLucas on 2016/5/2.
 */
public class Memorialfragment extends Fragment implements AdapterView.OnItemLongClickListener, View.OnLongClickListener {
    @Bind(R.id.lvview)
    ListView lv2;
    @Bind(R.id.cardview)
    CardView cardview;
    @Bind(R.id.cardviewdate)
    TextView cardviewdate;
    @Bind(R.id.cardviewdayshu)
    TextView cardviewdayshu;
    private List<Data> list = new ArrayList<>();
    private CardViewAdapter adapter;
    private View view;
    private Activity activity;
    private boolean frist = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.memorial_fragment, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        if (frist) {
            frist = false;
            MyApplication.list.clear();
            Log.e("mem", "123");
            RestoreData.restoreBridth("jinianri");
            list.addAll(MyApplication.list);

        }
        ButterKnife.bind(this, view);
        initAdapter();
        initListener();
        return view;
    }

    private void initListener() {
        lv2.setOnItemLongClickListener(this);
        cardview.setOnLongClickListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    private void initAdapter() {
        adapter = new CardViewAdapter(list, activity);
        lv2.setAdapter(adapter);
    }


    public void onSuccess(Data data) {
        list.add(data);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Gson g = new Gson();
        String toJson = g.toJson(list);
        SPUtils.save("jinianri", toJson);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), delet.class);
        intent.putExtra("position", position);
        startActivityForResult(intent, 4);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4) {
            int a = data.getIntExtra("pos", 0);
            list.remove(a);
            adapter.notifyDataSetChanged();
        }
        if (requestCode == 8) {
            String startdate = data.getStringExtra("title");
            String cradviewdis = data.getStringExtra("dayshu");
            Calendar c = Calendar.getInstance();
            String frsit = c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH);
            String xianshi = DateUtils.MathDay(cradviewdis,frsit);
            cardviewdate.setText(startdate);
            cardviewdayshu.setText(xianshi+"天");
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), dialogdate.class);
        startActivityForResult(intent, 8);
        return true;
    }
}
