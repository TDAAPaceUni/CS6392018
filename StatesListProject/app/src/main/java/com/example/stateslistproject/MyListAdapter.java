package com.example.stateslistproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder> {

    private String[] statesList;

    public interface ListItemClickListener {
        void onListItemClick(int position);
    }

    ListItemClickListener itemClickListener;

    public MyListAdapter(String[] statesList, ListItemClickListener itemClickListener) {
        this.statesList = statesList;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Boolean attachViewImmediatelyToParent = false;
        View singleItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.states_list_item,parent,attachViewImmediatelyToParent);
        MyViewHolder myViewHolder = new MyViewHolder(singleItemLayout);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.textDisplay.setText(statesList[position]);
    }

    @Override
    public int getItemCount() {
        return statesList.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textDisplay;

        public MyViewHolder(View itemView) {
            super(itemView);
            textDisplay = (TextView) itemView.findViewById(R.id.states_list);
            textDisplay.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onListItemClick(getAdapterPosition());
        }
    }
}
