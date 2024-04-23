package com.project.site.base.concurrent;




import groovy.lang.Singleton;

import java.util.concurrent.locks.ReentrantLock;


public class SingletonReduction {

    private static SingletonReduction instance = null;
    public static SingletonReduction factory(){
        if(instance == null)
            instance = new SingletonReduction();
        return instance;
    }
    private ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;
    public void perform (){
        lock.lock();
        try {
            // Critical section here
            counter++;
        } finally {
            //lock.unlock();
        }
    }
}
