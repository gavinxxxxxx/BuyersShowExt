package me.gavin.inject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.gavin.service.MjxManager;
import me.gavin.service.SettingManager;
import me.gavin.service.base.DataLayer;

/**
 * DataLayerModule
 *
 * @author gavin.xiong 2017/4/28
 */
@Module
public class DataLayerModule {

    @Singleton
    @Provides
    MjxManager provideMjxManager() {
        return new MjxManager();
    }

    @Singleton
    @Provides
    SettingManager provideSettingManager() {
        return new SettingManager();
    }

    @Singleton
    @Provides
    DataLayer provideDataLayer(MjxManager mjxManager, SettingManager settingManager) {
        return new DataLayer(mjxManager, settingManager);
    }
}
