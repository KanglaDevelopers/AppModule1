package com.dh.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dh.appmodule1.R;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment implements View.OnClickListener {


    private SlidingUpPanelLayout slidingUpPanelLayout;
    private Button buttonShow;
    private Button buttonHide;
    private TextView title;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        slidingUpPanelLayout = (SlidingUpPanelLayout) view.findViewById(R.id.sliding_layout);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity compatActivity = (AppCompatActivity) getActivity();
        compatActivity.setSupportActionBar(toolbar);
        buttonShow = (Button) view.findViewById(R.id.btn_show);
        buttonHide = (Button) view.findViewById(R.id.btn_hide);
        buttonShow.setOnClickListener(this);
        buttonHide.setOnClickListener(this);


        return view;
    }


    private SlidingPaneLayout.PanelSlideListener onPanelSlide(){
        return new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                title.setText("panel is sliding");

            }

            @Override
            public void onPanelOpened(View panel) {
                title.setText("panel is opening");

            }

            @Override
            public void onPanelClosed(View panel) {

                title.setText("panel is closing");
            }
        };
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_show) {
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            buttonShow.setVisibility(View.GONE);


        } else if (id == R.id.btn_hide) {

            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
            buttonShow.setVisibility(View.VISIBLE);
        }



    }

}
