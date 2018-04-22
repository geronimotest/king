package com.geronimo.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

@Module
public  class GeronimoAppModule {
    Application mApplication;

    public GeronimoAppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
