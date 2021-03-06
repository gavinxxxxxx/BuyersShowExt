package me.gavin.inject.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule
 *
 * @author gavin.xiong 2017/4/28
 */
@Module(includes = {
        DataLayerModule.class,
        ClientAPIModule.class,
        SharedPreferencesModule.class,
        DatabaseModule.class,
        CompositeDisposableModule.class
})
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    /**
     * 提供Application单例对象
     *
     * @return Application
     */
    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
