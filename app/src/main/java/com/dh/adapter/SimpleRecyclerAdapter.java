package com.dh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dh.appmodule1.R;

import java.util.ArrayList;

/**
 * Created by HUIDROM on 11/12/2015.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.MyViewHolder> {


    private ArrayList<String> data;
    private LayoutInflater inflater;
    private Context context;

    public SimpleRecyclerAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_adapter_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String title = data.get(position);
        holder.title.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
