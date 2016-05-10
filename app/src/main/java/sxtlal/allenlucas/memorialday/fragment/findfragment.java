package sxtlal.allenlucas.memorialday.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sxtlal.allenlucas.memorialday.Activity.*;
import sxtlal.allenlucas.memorialday.MainActivity;
import sxtlal.allenlucas.memorialday.R;


/**
 * Created by AllenLucas on 2016/5/2.
 */
public class findfragment extends Fragment {
    @Bind(R.id.good)
    RelativeLayout good;
    @Bind(R.id.math)
    RelativeLayout math;
    @Bind(R.id.report)
    RelativeLayout report;
    @Bind(R.id.about)
    RelativeLayout about;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null) {
            view = inflater.inflate(R.layout.findfragment, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.good, R.id.math, R.id.report, R.id.about})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.good:
                break;
            case R.id.math:
                startActivity(new Intent(getActivity(), sxtlal.allenlucas.memorialday.Activity.Math.class));
                break;
            case R.id.report:
                startActivity(new Intent(getActivity(),Report.class));
                break;
            case R.id.about:
                Intent intent = new Intent();
                intent.setClass(getActivity(),About.class);
                startActivity(intent);
                break;
        }
    }
}
