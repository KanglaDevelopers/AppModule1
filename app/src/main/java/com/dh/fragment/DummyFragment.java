package com.dh.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dh.adapter.SimpleRecyclerAdapter;
import com.dh.appmodule1.R;

import java.util.ArrayList;

/**
 * Created by HUIDROM on 11/12/2015.
 */
public class DummyFragment extends Fragment {
    String color;
    RecyclerView recyclerView;
    SimpleRecyclerAdapter simpleRecyclerAdapter;
    View view;

    public DummyFragment() {
    }

    @SuppressLint("ValidFragment")
    public DummyFragment(String color) {
        this.color = color;
    }

    ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add("ICS");
        data.add("JellyBean");
        data.add("Kitkat");
        data.add("Lollipop");
        data.add("Marshmallow");
        data.add("ICS");
        data.add("JellyBean");
        data.add("Kitkat");
        data.add("Lollipop");
        data.add("Marshmallow");
        data.add("ICS");
        data.add("JellyBean");
        data.add("Kitkat");
        data.add("Lollipop");
        data.add("Marshmallow");
        data.add("ICS");
        data.add("JellyBean");
        data.add("Kitkat");
        data.add("Lollipop");
        data.add("Marshmallow");
        data.add("ICS");
        data.add("JellyBean");
        data.add("Kitkat");
        data.add("Lollipop");
        data.add("Marshmallow");
        return data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dummy_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        simpleRecyclerAdapter = new SimpleRecyclerAdapter(getActivity(), getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(simpleRecyclerAdapter);
        view.setBackgroundColor(Color.parseColor(color));
        return view;
    }
   /* public void setBackgroundColor(String color){
        view.setBackgroundColor(Color.parseColor(color));
    }*/

    //  public abstract void set(String color);
}
