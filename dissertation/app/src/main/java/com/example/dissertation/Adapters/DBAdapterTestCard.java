package com.example.dissertation.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.R;
import com.example.dissertation.TestActivityPack.TestActivityCards;


import java.util.ArrayList;

public class DBAdapterTestCard extends RecyclerView.Adapter<DBAdapterTestCard.ViewHolder> {
    ArrayList<ModelClass> objModelClassTestCardArray;
    Context context;

    public DBAdapterTestCard(int recycleview_singlerow_cardstest, ArrayList<ModelClass> objModelClassTestCardArray) {
        this.objModelClassTestCardArray = objModelClassTestCardArray;
    }
    @Override
    public int getItemCount() {
        return objModelClassTestCardArray.size();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_singlerow_cardstest,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView item = holder.textView;
        item.setText(objModelClassTestCardArray.get(position).getStrings());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_TestTitleCard);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(context, TestActivityCards.class);
                    intent.putExtra("query_position",itemPosition);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
