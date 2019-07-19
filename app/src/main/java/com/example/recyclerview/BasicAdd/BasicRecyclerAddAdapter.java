package com.example.recyclerview.BasicAdd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerview.Basic.BasicRecyclerAdapter;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class BasicRecyclerAddAdapter extends RecyclerView.Adapter<BasicRecyclerAddAdapter.MyViewHolder> {
    private String[] mDataset;

    private ArrayList<BasicRecyclerAddData> arrayList;

    public BasicRecyclerAddAdapter(ArrayList<BasicRecyclerAddData> arrayList) {
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
    public BasicRecyclerAddAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BasicRecyclerAddAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.basic_recycler_add_rows, parent, false);

        BasicRecyclerAddAdapter.MyViewHolder vh = new BasicRecyclerAddAdapter.MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BasicRecyclerAddAdapter.MyViewHolder holder, int position) {
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
