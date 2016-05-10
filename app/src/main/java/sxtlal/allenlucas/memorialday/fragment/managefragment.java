package sxtlal.allenlucas.memorialday.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import sxtlal.allenlucas.memorialday.Activity.delet;
import sxtlal.allenlucas.memorialday.Adapter.CardViewAdapter;
import sxtlal.allenlucas.memorialday.Data;
import sxtlal.allenlucas.memorialday.MyApplication;
import sxtlal.allenlucas.memorialday.R;
import sxtlal.allenlucas.memorialday.RestoreData;
import sxtlal.allenlucas.memorialday.SPUtils;

/**
 * Created by AllenLucas on 2016/5/2.
 */
public class managefragment extends Fragment implements AdapterView.OnItemLongClickListener {

    @Bind(R.id.lvview2)
    ListView lvview2;
    @Bind(R.id.tv2)
    TextView tv2;
    private View view;
    private List<Data> list = new ArrayList<>();
    private CardViewAdapter adapter;
    private Activity activity;
    private boolean frist = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.manage_fragment, container, false);
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
            RestoreData.restoreBridth("shengri");
            list.addAll(MyApplication.list);
        }
        ButterKnife.bind(this, view);
        initAdapter();
        initListener();
        return view;
    }

    private void initListener() {
        lvview2.setOnItemLongClickListener(this);
    }

    private void initAdapter() {
        adapter = new CardViewAdapter(list,activity);
        lvview2.setAdapter(adapter);
        lvview2.setEmptyView(view.findViewById(R.id.tv2));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
    }
    public void onSuccess2(Data data) {
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
        SPUtils.save("shengri", toJson);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), delet.class);
        intent.putExtra("position",position);
        startActivityForResult(intent, 5);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==5){
            int a = data.getIntExtra("pos",0);
            list.remove(a);
            adapter.notifyDataSetChanged();
        }
    }
}
