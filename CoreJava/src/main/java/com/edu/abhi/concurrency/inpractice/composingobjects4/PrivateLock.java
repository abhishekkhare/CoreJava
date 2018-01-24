package com.edu.abhi.concurrency.inpractice.composingobjects4;

import apple.laf.JRSUIConstants.Widget;
import com.edu.abhi.concurrency.inpractice.annotations.GuardedBy;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}