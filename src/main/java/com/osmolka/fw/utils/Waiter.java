package com.osmolka.fw.utils;

public class Waiter {

    public static void waitABit(long duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
