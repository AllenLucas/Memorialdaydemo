package sxtlal.allenlucas.memorialday.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sxtlal.allenlucas.memorialday.Data;
import sxtlal.allenlucas.memorialday.R;

/**
 * Created by AllenLucas on 2016/5/3.
 */
public class CardViewAdapter extends BaseAdapter {
    private List<Data> list;
    private Context context;

    public CardViewAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("easda","dsawdadsa");
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.cardview,null);
            viewHolder=new ViewHolder();
            viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            viewHolder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
            viewHolder.tv4 = (TextView) convertView.findViewById(R.id.tv4);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText(list.get(position).getDate());
        viewHolder.tv4.setText(list.get(position).getTime());
        return convertView;
    }
    class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv4;
    }
}
