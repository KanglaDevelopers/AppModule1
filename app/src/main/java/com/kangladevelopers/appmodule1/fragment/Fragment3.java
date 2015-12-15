package com.kangladevelopers.appmodule1.fragment;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Toast;


import com.kangladevelopers.appmodule1.R;
import com.kangladevelopers.appmodule1.adapter.CardViewAdapter;
import com.kangladevelopers.appmodule1.helper.OnStartDragListener;
import com.kangladevelopers.appmodule1.helper.SimpleItemTouchHelperCallback;
import com.kangladevelopers.appmodule1.model.ViewCardModel;

import java.util.ArrayList;



public class Fragment3 extends Fragment implements OnStartDragListener {


    private RecyclerView recyclerView;
    private CardViewAdapter cardViewAdapter;
    private ObjectAnimator objectAnimator;
    private Interpolator interpolator = new AccelerateInterpolator();
    private ItemTouchHelper itemTouchHelper;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        cardViewAdapter = new CardViewAdapter(getActivity(), getData(), new CardViewAdapter.RecyclerViewListener() {
            @Override
            public void OnRecyclerViewClick(View view, int position) {

                int i = view.getId();
                switch (i) {
                    case R.id.bubbleText:
                        objectAnimator = ObjectAnimator.ofFloat(view, "rotationY", 0, 360);
                        objectAnimator.setDuration(700);
                        objectAnimator.setInterpolator(interpolator);
                        objectAnimator.start();
                        break;
                    case R.id.titleTxt:
                        objectAnimator = ObjectAnimator.ofFloat(view, "rotationX", 0, 360);
                        objectAnimator.setDuration(700);
                        objectAnimator.setInterpolator(interpolator);
                        objectAnimator.start();
                        break;
                    case R.id.message_body:
                        objectAnimator = ObjectAnimator.ofFloat(view, "rotationY", 360, 0);
                        objectAnimator.setDuration(700);
                        objectAnimator.setInterpolator(interpolator);
                        objectAnimator.start();
                        break;

                }

                Toast.makeText(getContext(), position + "", Toast.LENGTH_LONG).show();
            }
        },this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(cardViewAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        recyclerView.setAdapter(cardViewAdapter);
       /* recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //    TextView bubbleText = (TextView) view.findViewById(R.id.bubbleText);
                objectAnimator = ObjectAnimator.ofFloat(view, "rotationY", 0, 360);
                objectAnimator.setDuration(700);
                objectAnimator.setInterpolator(interpolator);
                objectAnimator.start();

            }
        }));
*/

        return view;
    }

    private ArrayList<ViewCardModel> getData() {
        ArrayList<ViewCardModel> data = new ArrayList<ViewCardModel>();
        for (int i = 0; i < 30; i++) {
            data.add(new ViewCardModel(i + "", "Title " + i, getResources().getString(R.string.message_body)));
        }

        return data;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {

        itemTouchHelper.startDrag(viewHolder);
    }

    static public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {


        private OnItemClickListener onItemClickListener;
        private GestureDetector gestureDetector;
        private Context context;

        interface OnItemClickListener {
            void onItemClick(View view, int position);
        }


        public RecyclerItemClickListener(Context context, OnItemClickListener onItemClickListener) {
            this.context = context;
            this.onItemClickListener = onItemClickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {

            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && onItemClickListener != null && gestureDetector.onTouchEvent(e)) {
                onItemClickListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }



}
