package com.geronimo;

import android.app.Application;

import com.geronimo.injection.DaggerKingComponent;
import com.geronimo.injection.GeronimoAppModule;
import com.geronimo.injection.KingComponent;
import com.geronimo.injection.KingModule;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

public class GeronimoApp extends Application{
    private KingComponent kingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        kingComponent = DaggerKingComponent.builder().geronimoAppModule(new GeronimoAppModule(this)).kingModule(new KingModule()).build();

        //kingComponent = DaggerKingComponent .builder().appModule(new GeronimoAppModule(this)).rssFeedModule(new KingModule()).build();
    }

    public KingComponent getKingComponent() {
       return kingComponent;
    }
}
