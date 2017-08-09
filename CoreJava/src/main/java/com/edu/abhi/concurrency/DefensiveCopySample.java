package com.edu.abhi.concurrency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefensiveCopySample {
    List<String> list = new ArrayList<String>();

    public void add(String s) {
        list.add(s);
    }

    /**
     * Makes a defensive copy of the List and return it
     * This way cannot modify the list itself
     *
     * @return List<String>
     */
    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}