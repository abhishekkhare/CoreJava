package com.edu.abhi.question.chessgame;

public class Move {
	private Square from;
    private Square to;
    private Piece pieceMoved;
    private Piece PieceCaptured;
	public Square getFrom() {
		return from;
	}
	public void setFrom(Square from) {
		this.from = from;
	}
	public Square getTo() {
		return to;
	}
	public void setTo(Square to) {
		this.to = to;
	}
	public Piece getPieceMoved() {
		return pieceMoved;
	}
	public void setPieceMoved(Piece pieceMoved) {
		this.pieceMoved = pieceMoved;
	}
	public Piece getPieceCaptured() {
		return PieceCaptured;
	}
	public void setPieceCaptured(Piece pieceCaptured) {
		PieceCaptured = pieceCaptured;
	}
	public Move(Square from, Square to, Piece pieceMoved, Piece pieceCaptured) {
		this.from = from;
		this.to = to;
		this.pieceMoved = pieceMoved;
		PieceCaptured = pieceCaptured;
	}
    

}
