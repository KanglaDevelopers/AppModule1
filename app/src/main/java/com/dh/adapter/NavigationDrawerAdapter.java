package com.dh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dh.appmodule1.R;
import com.dh.model.NavDrawerItem;

import java.util.List;

/**
 * Created by HUIDROM on 11/8/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    private List<NavDrawerItem> data;
    private Context context;
    private LayoutInflater inflater;


    public NavigationDrawerAdapter(Context context,List<NavDrawerItem> data) {
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
