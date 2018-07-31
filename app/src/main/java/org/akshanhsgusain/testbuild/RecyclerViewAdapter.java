package org.akshanhsgusain.testbuild;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    ArrayList<ModelClass> data=new ArrayList<>();
    Context mContext;

    public RecyclerViewAdapter(ArrayList<ModelClass> data, Context mContext) {
        this.data = data;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        ViewHolder vh= new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.mtextView.setText(data.get(position).getSingleItem());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mtextView=itemView.findViewById(R.id.textView);
            }
    }
    public void setFilters(ArrayList<ModelClass> model){
                  data=new ArrayList<>();
                  data.addAll(model);
                  notifyDataSetChanged();
    }
}
