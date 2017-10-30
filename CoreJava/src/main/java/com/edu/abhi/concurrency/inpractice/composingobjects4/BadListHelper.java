package com.edu.abhi.concurrency.inpractice.composingobjects4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;
import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@NotThreadSafe
class BadListHelper <E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent)
            list.add(x);
        return absent;
    }
}

@ThreadSafe
class GoodListHelper <E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}
