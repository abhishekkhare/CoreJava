package com.edu.abhi.question.chessgame;

public class Square {
	private Integer x;
	private Integer y;

	public  Square(String str) {
        // Parses strings like "a1" so you can write "a1" in code instead
        // of new Square(0, 0)
    }
    public  Square(Integer x,Integer y) {
    	this.x=x;
    	this.y=y;
    }
    
    public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
}
