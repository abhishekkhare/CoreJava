package com.edu.abhi.concurrency.inpractice.composingobjects4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

@ThreadSafe
public class DelegatingVehicleTracker {
	private final ConcurrentMap<String, Point> locations;
	private final Map<String, Point> unmodifiableMap;

	public DelegatingVehicleTracker(Map<String, Point> points) {
		locations = new ConcurrentHashMap<String, Point>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}

	public Map<String, Point> getLocations() {
		return unmodifiableMap;
	}

	public Point getLocation(String id) {
		return locations.get(id);
	}

	public void setLocation(String id, int x, int y) {
		if (locations.replace(id, new Point(x, y)) == null)
			throw new IllegalArgumentException("invalid vehicle name: " + id);
	}

	// Alternate version of getLocations (Listing 4.8)
	public Map<String, Point> getLocationsAsStatic() {
		return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
	}
}
