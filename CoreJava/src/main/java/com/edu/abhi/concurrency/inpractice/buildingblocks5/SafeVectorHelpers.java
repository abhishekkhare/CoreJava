package com.edu.abhi.concurrency.inpractice.buildingblocks5;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

import java.util.Vector;

@ThreadSafe
public class SafeVectorHelpers {
	public static Object getLast(Vector list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			return list.get(lastIndex);
		}
	}

	public static void deleteLast(Vector list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			list.remove(lastIndex);
		}
	}
}
