package com.edu.abhi.concurrency.inpractice.buildingblocks5;

import com.edu.abhi.concurrency.inpractice.annotations.GuardedBy;
import com.edu.abhi.concurrency.inpractice.annotations.NotThreadSafe;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@NotThreadSafe
public class HiddenIterator {
    @GuardedBy("this") private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        System.out.println("DEBUG: added ten elements to " + set);
    }
}
