package com.dh.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dh.appmodule1.R;
import com.dh.fragment.Fragment3;
import com.dh.helper.ItemTouchHelperAdapter;
import com.dh.helper.ItemTouchHelperViewHolder;
import com.dh.helper.OnStartDragListener;
import com.dh.model.ViewCardModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HUIDROM on 11/14/2015.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> implements ItemTouchHelperAdapter {


    private Fragment3.RecyclerItemClickListener clickListener;
    private ArrayList<ViewCardModel> data;
    private Context context;
    private LayoutInflater inflater;
    private RecyclerViewListener recyclerViewListener;
    private OnStartDragListener mDragStartListener;

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        Collections.swap(data, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

        data.remove(position);
        notifyItemRemoved(position);
    }

    public interface RecyclerViewListener {
        void OnRecyclerViewClick(View view, int position);
    }

    public CardViewAdapter(Context context, ArrayList<ViewCardModel> data, RecyclerViewListener recyclerViewListener,OnStartDragListener mDragStartListener) {
        this.context = context;
        this.data = data;
        this.recyclerViewListener = recyclerViewListener;
        this.mDragStartListener =mDragStartListener;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cardview_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.bubbleText.setText(data.get(position).getBubbleText());
        holder.title.setText(data.get(position).getTitle());
        holder.messageBody.setText(data.get(position).getMessageBody());
        TextView tt = holder.bubbleText;
        holder.messageBody.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {

        private TextView bubbleText;
        private TextView title;
        private TextView messageBody;

        public MyViewHolder(View itemView) {
            super(itemView);
            bubbleText = (TextView) itemView.findViewById(R.id.bubbleText);
            title = (TextView) itemView.findViewById(R.id.titleTxt);
            messageBody = (TextView) itemView.findViewById(R.id.message_body);
            bubbleText.setOnClickListener(this);
            title.setOnClickListener(this);
            messageBody.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            recyclerViewListener.OnRecyclerViewClick(v, this.getLayoutPosition());

        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {

            itemView.setBackgroundColor(0);
        }
    }
}
