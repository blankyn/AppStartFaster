package com.blankm.launcher.test;

import android.app.Application;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;

import me.blankm.launcher.task.AppStartTask;

public class TestAppStartTaskFour extends AppStartTask {

    public TestAppStartTaskFour(Application application) {
        super(application);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
        Log.i("Task:","TestAppStartTaskFour执行耗时: "+(System.currentTimeMillis()-start));
    }

    @Override
    public List<Class<? extends AppStartTask>> getDependsTaskList() {
        List<Class<? extends AppStartTask>> dependsTaskList = new ArrayList<>();
        dependsTaskList.add(TestAppStartTaskTwo.class);
        dependsTaskList.add(TestAppStartTaskThree.class);
        return dependsTaskList;
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }

}
