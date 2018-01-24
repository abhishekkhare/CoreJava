package com.edu.abhi.concurrency.inpractice.composingobjects4;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

import java.util.Vector;

@ThreadSafe
public class BetterVector <E> extends Vector<E> {
    // When extending a serializable class, you should redefine serialVersionUID
    static final long serialVersionUID = -3963416950630760754L;

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent)
            add(x);
        return absent;
    }
}