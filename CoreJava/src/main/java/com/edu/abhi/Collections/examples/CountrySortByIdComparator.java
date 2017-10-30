package com.edu.abhi.Collections.examples;

import java.util.Comparator;

public class CountrySortByIdComparator implements Comparator<Country> {

	@Override
	public int compare(Country country1, Country country2) {
		return country1.getCountryName().compareTo(country2.getCountryName());
	}

}