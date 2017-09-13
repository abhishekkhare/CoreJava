package com.edu.abhi.question.chessgame;

public class Piece {
	private PieceType Type;
	private PieceColor Color;
	public PieceType getType() {
		return Type;
	}
	public void setType(PieceType type) {
		Type = type;
	}
	public PieceColor getColor() {
		return Color;
	}
	public void setColor(PieceColor color) {
		Color = color;
	}
	public Piece(PieceType type, PieceColor color) {
		super();
		Type = type;
		Color = color;
	}
	
	
}
