package me.gavin.inject.component;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import me.gavin.app.TaskService;
import me.gavin.base.BaseActivity;
import me.gavin.db.dao.DaoSession;
import me.gavin.inject.module.ApplicationModule;
import me.gavin.service.base.BaseManager;

/**
 * ApplicationComponent
 *
 * @author gavin.xiong 2017/4/28
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    void inject(TaskService service);

//    void inject(BaseFragment fragment);

    void inject(BaseManager manager);

    // 可以获取 ApplicationModule 及其 includes 的所有 Module 提供的对象（方法名随意）
    Application getApplication();

    DaoSession getDaoSession();

    class Instance {

        private static ApplicationComponent sComponent;

        public static void set(@NonNull ApplicationComponent component) {
            sComponent = component;
        }

        public static ApplicationComponent get() {
            return sComponent;
        }
    }
}
