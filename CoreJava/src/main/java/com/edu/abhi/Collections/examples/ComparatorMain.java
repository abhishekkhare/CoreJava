package com.edu.abhi.Collections.examples;

import java.util.*;
import java.util.Map.Entry;

public class ComparatorMain {
	public static void main(String[] args) {
		//sortListById();
		//sortListByName();
		sortMapById();
		sortMapByName();
		linkedHashMap();
		
		
	}

	private static void linkedHashMap() {

		System.out.println("By Insertion Order");
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");
		Map<Country,String> mapOfCountryCapital = new LinkedHashMap<Country,String>();
		mapOfCountryCapital.put(indiaCountry, "New Delhi");
		mapOfCountryCapital.put(chinaCountry, "Bejing");
		mapOfCountryCapital.put(nepalCountry, "Katmandu");
		mapOfCountryCapital.put(bhutanCountry, "Bhutan");
		Set<Entry<Country,String>> entrySet = mapOfCountryCapital.entrySet();
		for (Iterator <Entry<Country, String>>iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Country, String> entry =  iterator.next();
			System.out.println("Country Id: " + entry.getKey().getCountryId() + "||"
					+ "Country name: " + entry.getKey().getCountryName() + "||"+ "Country Capital: " + entry.getValue());
		}	
	
		
	}

	private static void sortMapByName() {
		System.out.println("By Name");
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");
		CountrySortByIdComparator comparator = new CountrySortByIdComparator();
		Map<Country,String> mapOfCountryCapital = new TreeMap<Country,String>(comparator);
		mapOfCountryCapital.put(indiaCountry, "New Delhi");
		mapOfCountryCapital.put(chinaCountry, "Bejing");
		mapOfCountryCapital.put(nepalCountry, "Katmandu");
		mapOfCountryCapital.put(bhutanCountry, "Bhutan");
		Set<Entry<Country,String>> entrySet = mapOfCountryCapital.entrySet();
		for (Iterator <Entry<Country, String>>iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Country, String> entry =  iterator.next();
			System.out.println("Country Id: " + entry.getKey().getCountryId() + "||"
					+ "Country name: " + entry.getKey().getCountryName() + "||"+ "Country Capital: " + entry.getValue());
		}	
	}

	private static void sortMapById() {
		System.out.println("By ID");
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");
		
		Map<Country,String> mapOfCountryCapital = new TreeMap<Country,String>();
		mapOfCountryCapital.put(indiaCountry, "New Delhi");
		mapOfCountryCapital.put(chinaCountry, "Bejing");
		mapOfCountryCapital.put(nepalCountry, "Katmandu");
		mapOfCountryCapital.put(bhutanCountry, "Bhutan");
		Set<Entry<Country,String>> entrySet = mapOfCountryCapital.entrySet();
		for (Iterator <Entry<Country, String>>iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Country, String> entry =  iterator.next();
			System.out.println("Country Id: " + entry.getKey().getCountryId() + "||"
					+ "Country name: " + entry.getKey().getCountryName() + "||"+ "Country Capital: " + entry.getValue());
		}
	}

	private static void sortListByName() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);

		System.out.println("Before Sort By Name  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "||"
					+ "Country name: " + country.getCountryName());
		}
		
		CountrySortByIdComparator comparator = new CountrySortByIdComparator();
		Collections.sort(listOfCountries, comparator);

		System.out.println("After Sort  By Name : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "|| "
					+ "Country name: " + country.getCountryName());
		}
		
	}

	private static void sortListById() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);

		System.out.println("Before Sort By ID  : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "||"
					+ "Country name: " + country.getCountryName());
		}
		Collections.sort(listOfCountries);

		System.out.println("After Sort  By ID : ");
		for (int i = 0; i < listOfCountries.size(); i++) {
			Country country = (Country) listOfCountries.get(i);
			System.out.println("Country Id: " + country.getCountryId() + "|| "
					+ "Country name: " + country.getCountryName());
		}

	}
}
