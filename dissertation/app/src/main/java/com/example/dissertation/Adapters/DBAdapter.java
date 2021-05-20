package com.example.dissertation.Adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dissertation.GettersSetters.ModelClass;
import com.example.dissertation.R;
import com.zolad.zoominimageview.ZoomInImageView;
import java.util.ArrayList;


public class DBAdapter extends RecyclerView.Adapter<DBAdapter.DBViewHolder> implements Filterable {
    ArrayList<ModelClass> objModelClassArrayList;
    ArrayList<ModelClass> objModelClassArrayListNEW;
    private Context context;
    public  static class DBViewHolder extends RecyclerView.ViewHolder {
        TextView description_sign;
        ZoomInImageView image_sign;
        public DBViewHolder(@NonNull View itemView) {
            super(itemView);
            description_sign = itemView.findViewById(R.id.singleRow_TextView_Activity);
            image_sign = itemView.findViewById(R.id.signleRow_ImageView_Activity);
        }
    }
    public DBAdapter (ArrayList<ModelClass> objModelClassArrayList){
        this.objModelClassArrayList = objModelClassArrayList;
        objModelClassArrayListNEW = new ArrayList<>(objModelClassArrayList);
    }
    @NonNull
    @Override
    public DBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View signleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_singlerow_activity,
                                                                                parent,false);
        // set the Context here
        context = parent.getContext();
        return new DBViewHolder(signleRow);
    }
    @Override
    public void onBindViewHolder(@NonNull DBViewHolder holder, int position) {

        ModelClass objModelClass = objModelClassArrayList.get(position);

        //holder.description_sign.setText(objModelClass.getDescription());
        //holder.image_sign.setImageBitmap(objModelClass.getImage());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.description_sign.setText(Html.fromHtml(objModelClass.getDescription(),Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.description_sign.setText(Html.fromHtml(objModelClass.getDescription()));
        }

        String uri = "@drawable/" + objModelClass.getImage();
        int imageResource = holder.itemView.getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
        //Drawable res = holder.itemView.getResources().getDrawable(imageResource);
        holder.image_sign.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return objModelClassArrayList.size();
    }
    @Override
    public Filter getFilter() {

        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<ModelClass> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0 ){
                filteredList.addAll(objModelClassArrayListNEW);
            }else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (ModelClass item : objModelClassArrayListNEW){
                    if (item.getDescription().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                objModelClassArrayList.clear();
                objModelClassArrayList.addAll((ArrayList)filterResults.values);  // list
                notifyDataSetChanged();
        }
    };
}
