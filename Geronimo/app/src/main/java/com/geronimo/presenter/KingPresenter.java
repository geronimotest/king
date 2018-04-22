package com.geronimo.presenter;

import android.app.Activity;
import android.content.Context;

import com.geronimo.model.King;

/**
 * Created by Babacar Cisse on 22/04/2018.
 */

public interface KingPresenter {
    void  listKings(Activity context);

    void addNewKing(Activity context);

    void share(Context context, King king);

    void showDetailsAsToast(Context context, King king);
}
