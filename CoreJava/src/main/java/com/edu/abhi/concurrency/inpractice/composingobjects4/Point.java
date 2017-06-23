package com.edu.abhi.concurrency.inpractice.composingobjects4;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}