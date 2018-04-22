package com.geronimo.injection;

import com.geronimo.model.KingItemsRetriever;
import com.geronimo.model.KingItemsRetrieverImpl;
import com.geronimo.presenter.KingPresenter;
import com.geronimo.presenter.KingPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */


@Module
public class KingModule {

    @Provides
    @Singleton
    public KingItemsRetriever provideKingRetriever(){
        return new KingItemsRetrieverImpl();
    }

    @Provides
    @Singleton
    public KingPresenter providePresenter(){
        return new KingPresenterImpl();
    }



}
