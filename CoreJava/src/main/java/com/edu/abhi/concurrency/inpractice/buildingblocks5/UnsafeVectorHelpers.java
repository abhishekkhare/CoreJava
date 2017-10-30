package com.edu.abhi.concurrency.inpractice.buildingblocks5;

import java.util.Vector;

import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}