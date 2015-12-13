package com.dh.helper;

/**
 * Created by HUIDROM on 11/15/2015.
 */
public interface  ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition,int toPosition);
    void onItemDismiss(int position);
}
