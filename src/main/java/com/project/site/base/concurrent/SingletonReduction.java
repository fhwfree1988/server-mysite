package com.project.site.base.concurrent;

import groovy.lang.Singleton;

import java.util.concurrent.locks.ReentrantLock;

@Singleton
public class SingletonReduction {

    private static ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;
    public static void perform (){
        lock.lock();
        try {
            // Critical section here
            counter++;
        } finally {
            //lock.unlock();
        }
    }
}
