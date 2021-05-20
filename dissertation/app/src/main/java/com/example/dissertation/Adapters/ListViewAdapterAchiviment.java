package com.example.dissertation.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dissertation.GettersSetters.ListViewModel;
import com.example.dissertation.R;

import java.util.ArrayList;

public class ListViewAdapterAchiviment extends BaseAdapter {

    Context context;
    ArrayList<ListViewModel> listViewModels;
    public ListViewAdapterAchiviment(Context context, ArrayList<ListViewModel> listViewModels){
        this.context = context;
        this.listViewModels = listViewModels;
    }
    @Override
    public int getCount() {
        return this.listViewModels.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.achiviement_row,null);
            TextView counter = (TextView) view.findViewById(R.id.textTestNumber);
            TextView score = (TextView)view.findViewById(R.id.textPoint);
            TextView date = (TextView)view.findViewById(R.id.textviewDate);

            ListViewModel listViewModel = listViewModels.get(position);
            counter.setText("Nr:"+listViewModel.getCounter());
            score.setText("Puncte:"+listViewModel.getScore());
            date.setText("Data:"+listViewModel.getDate());
            int colored = Integer.parseInt(listViewModel.getScore());
            if (colored<=20){
                view.findViewById(R.id.layout_row_achiviement).setBackgroundColor(Color.RED);
            }else {
                view.findViewById(R.id.layout_row_achiviement).setBackgroundColor(Color.GREEN);
            }
        return view;
    }
}

