package com.example.dissertation.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dissertation.R;

public class ListViewAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] textView;

    public ListViewAdapter(Context context, String[] textView){
        super(context, R.layout.listview_singlerow,textView);
        this.context = context;
        this.textView = textView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.listview_singlerow,null,true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
            viewHolder.tv.setText(textView[position]);


        return view;
    }
    class ViewHolder {
        TextView tv;
        ViewHolder(View view){
            tv = (TextView) view.findViewById(R.id.textView_customListView);
        }
    }
}
