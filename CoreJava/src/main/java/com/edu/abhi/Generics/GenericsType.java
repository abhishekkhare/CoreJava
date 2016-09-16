package com.edu.abhi.Generics;

public class GenericsType<T> {
	 
    private T t;
     
    public T get(){
        return this.t;
    }
     
    public void set(T t1){
        this.t=t1;
    }
     
    public static void main(String args[]){
        GenericsType<String> type = new GenericsType<>();
        type.set("Pankaj"); //valid
        //type.set(10);//compiler error
        GenericsType type1 = new GenericsType(); //raw type
        type1.set("Pankaj"); //valid
        type1.set(10); //valid and autoboxing support
    }
}