package com.blankm.launcher.test;

import android.app.Application;
import android.util.Log;



import java.util.List;

import me.blankm.launcher.task.AppStartTask;

public class TestAppStartTaskOne extends AppStartTask {

    public TestAppStartTaskOne(Application application) {
        super(application);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        }catch (Exception e){
        }
        Log.i("Task:","TestAppStartTaskOne执行耗时: "+(System.currentTimeMillis()-start));
    }

    @Override
    public List<Class<? extends AppStartTask>> getDependsTaskList() {
        return null;
    }

    @Override
    public boolean isRunOnMainThread() {
        return true;
    }


}
