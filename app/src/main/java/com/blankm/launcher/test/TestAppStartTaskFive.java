package com.blankm.launcher.test;

import android.app.Application;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import me.blankm.launcher.task.AppStartTask;

public class TestAppStartTaskFive extends AppStartTask {

    public TestAppStartTaskFive(Application application) {
        super(application);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        }catch (Exception e){
        }
        Log.i("Task:","TestAppStartTaskFive执行耗时: " + (System.currentTimeMillis() - start));
    }

    @Override
    public List<Class<? extends AppStartTask>> getDependsTaskList() {
        List<Class<? extends AppStartTask>> dependsTaskList = new ArrayList<>();
        dependsTaskList.add(TestAppStartTaskThree.class);
        dependsTaskList.add(TestAppStartTaskTwo.class);
        return dependsTaskList;
    }

    @Override
    public Executor runOnExecutor() {
        return super.runOnExecutor();
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }


}
