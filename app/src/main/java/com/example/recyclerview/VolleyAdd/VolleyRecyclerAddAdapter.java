package com.example.recyclerview.VolleyAdd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.VolleyAdd.VolleyRecyclerAddData;

import java.util.ArrayList;

public class VolleyRecyclerAddAdapter extends RecyclerView.Adapter<VolleyRecyclerAddAdapter.MyViewHolder> {
    private String[] mDataset;

    private ArrayList<VolleyRecyclerAddData> arrayList;

    public VolleyRecyclerAddAdapter(ArrayList<VolleyRecyclerAddData> arrayList) {
        this.arrayList = arrayList;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_title;
        public TextView TextView_content;
        public ImageView ImageView_title;

        public MyViewHolder(View v) {
            super(v);
            TextView_title = v.findViewById(R.id.TextView_title);
            TextView_content = v.findViewById(R.id.TextView_content);
            ImageView_title = v.findViewById(R.id.ImageView_title);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public VolleyRecyclerAddAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VolleyRecyclerAddAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.volley_recycler_add_rows, parent, false);

        VolleyRecyclerAddAdapter.MyViewHolder vh = new VolleyRecyclerAddAdapter.MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(VolleyRecyclerAddAdapter.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //holder.TextView_title.setText(mDataset[position]);
        //holder.TextView_content.setText("Text Position " + mDataset[position]);

        holder.TextView_title.setText(arrayList.get(position).getTextView_title());
        holder.TextView_content.setText(arrayList.get(position).getTextView_content());
        holder.ImageView_title.setImageResource(arrayList.get(position).getImageView_title());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {


        // return mDataset.length;   // 배열 사용으로 주석 처리

        return (null != arrayList ? arrayList.size() : 0 );
    }


}
