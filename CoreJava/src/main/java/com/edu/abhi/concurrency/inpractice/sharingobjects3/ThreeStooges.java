package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public final class ThreeStooges {
   private final Set<String> stooges = new HashSet<String>();

   public ThreeStooges() {
       stooges.add("Moe");
       stooges.add("Larry");
       stooges.add("Curly");
   }

   public boolean isStooge(String name) {
       return stooges.contains(name);
   }

   public String getStoogeNames() {
       List<String> stooges = new Vector<String>();
       stooges.add("Moe");
       stooges.add("Larry");
       stooges.add("Curly");
       return stooges.toString();
   }
   
   public static void main(String [] args){
	   ThreeStooges s = new ThreeStooges();
	   
   }
}
