package com.edu.abhi.ooda.p1;
/**
 * 
 * @author abhishekkhare
 *
 */
public enum Type { 

  ACOUSTIC, ELECTRIC;

  public String toString() {
    switch(this) {
      case ACOUSTIC: return "acoustic";
      case ELECTRIC: return "electric";
      default:       return "unspecified";
    }
  }
}
