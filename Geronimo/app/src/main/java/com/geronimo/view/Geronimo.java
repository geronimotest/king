package com.geronimo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.geronimo.GeronimoApp;
import com.geronimo.R;
import com.geronimo.model.King;
import com.geronimo.presenter.KingPresenterImpl;
import com.geronimo.view.adapter.KingAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Geronimo extends AppCompatActivity {

    @Inject
    KingPresenterImpl kingPresenter;

    @BindView(R.id.kings)
    protected RecyclerView kings;

    private KingAdapter adapter;

    private List<King> allKings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geronimo);

        ButterKnife.bind(this);

        adapter = new KingAdapter(this, allKings);

        ((GeronimoApp)getApplication()).getKingComponent().inject(this);
        kingPresenter.listKings(this);
    }


    public void displayList(List<King>kingsItem){
        allKings.addAll(kingsItem);
        kings.setAdapter(adapter);
        kings.setLayoutManager(new LinearLayoutManager(this));
    }

    public void share(King king){
        kingPresenter.share(this,king);
    }

    public void showDetailsAsToast(King king){
        kingPresenter.showDetailsAsToast(this,king);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public void addKing(King ... kings){
        for(King king : kings){
            allKings.add(king);
            adapter.notifyDataSetChanged();
        }
        this.kings.smoothScrollToPosition (allKings.size()-1);
    }

    public void killAKing(){
       if(!allKings.isEmpty()){
           allKings.remove(allKings.size()-1);
           adapter.notifyDataSetChanged();
           if(allKings.size()-1 >= 0) {
               kings.smoothScrollToPosition(allKings.size() - 1);
           }
       }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.del:
                killAKing();
                return true;

            case R.id.add:
                kingPresenter.addNewKing(this);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
