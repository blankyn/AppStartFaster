package com.blankm.launcher.application;

import android.app.Application;
import android.content.Context;

import com.blankm.launcher.multidex.MultidexUtils;
import com.blankm.launcher.test.TestAppStartTaskFive;
import com.blankm.launcher.test.TestAppStartTaskFour;
import com.blankm.launcher.test.TestAppStartTaskOne;
import com.blankm.launcher.test.TestAppStartTaskThree;
import com.blankm.launcher.test.TestAppStartTaskTwo;

import me.blankm.launcher.dispatcher.AppStartTaskDispatcher;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (MultidexUtils.isMainProcess(this)){
        AppStartTaskDispatcher.getInstance()
                .setContext(this)
                .setShowLog(true)
                .setAllTaskWaitTimeOut(1000)
                .addAppStartTask(new TestAppStartTaskTwo(this))
                .addAppStartTask(new TestAppStartTaskFour(this))
                .addAppStartTask(new TestAppStartTaskFive(this))
                .addAppStartTask(new TestAppStartTaskThree(this))
                .addAppStartTask(new TestAppStartTaskOne(this))
                .start()
                .await();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        boolean isMainProcess = MultidexUtils.isMainProcess(base);
        if (isMainProcess && !MultidexUtils.isVMMultidexCapable()){
            MultidexUtils.loadMultiDex(base);
        }else {
            MultidexUtils.preNewActivity();
        }
    }
}
