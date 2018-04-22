package com.geronimo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.geronimo.view.Geronimo;
import com.geronimo.GeronimoApp;
import com.geronimo.R;
import com.geronimo.model.King;
import com.geronimo.model.KingItemsRetriever;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

public class KingPresenterImpl implements KingPresenter{

    @Inject
    KingItemsRetriever kingItemsRetriever;

    @Inject
    public KingPresenterImpl(){

    }


    @Override
    public void listKings(Activity context) {
        ((GeronimoApp)context.getApplication()).getKingComponent().inject(this);
        List<King> kings = kingItemsRetriever.listKings();
        ((Geronimo)context).displayList(kings);
    }

    @Override
    public void addNewKing(Activity context) {
        King newKing = kingItemsRetriever.newKing();
        ((Geronimo)context).addKing(newKing);
    }

    @Override
    public void share(Context context, King king) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, king.getTitle());
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, king.getDescription());
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, context.getString(R.string.share)));
    }

    @Override
    public void showDetailsAsToast(Context context, King king) {
        Toast.makeText(context, context.getString(R.string.details)+": "+king.getTitle(), Toast.LENGTH_SHORT).show();
    }


}
