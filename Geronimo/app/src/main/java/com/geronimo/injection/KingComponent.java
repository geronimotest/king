package com.geronimo.injection;

import com.geronimo.view.Geronimo;
import com.geronimo.presenter.KingPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Babacar Cisse on 21/04/2018.
 */

@Singleton
@Component(modules = {KingModule.class,GeronimoAppModule.class})
public interface KingComponent {

    void inject(KingPresenter presenter);

    void inject(Geronimo geronimo);
}
