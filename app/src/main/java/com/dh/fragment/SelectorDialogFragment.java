package com.dh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dh.appmodule1.R;

/**
 * Created by HUIDROM on 11/10/2015.
 */
public abstract class SelectorDialogFragment extends DialogFragment {
    private Button galleryButton;
    public SelectorDialogFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selector_dialog_fragment,container,false);
        galleryButton = (Button) view.findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGalleryClick();
            }
        });
        getDialog().setTitle("Simple Dialog");

        return view;
    }

   public abstract void onGalleryClick();

}
