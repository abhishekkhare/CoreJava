package com.edu.abhi.question.chessgame;

import java.util.HashMap;
import java.util.Map;

public class Board {
	private static Map<Square, Piece> board = new HashMap<Square, Piece>();

	public Board(){
		for (PieceColor color : PieceColor.values()) {
			for(PieceType pieceType : PieceType.values()){
				switch(pieceType){
					case Bishop:{
						Piece piece1 = new Piece(pieceType, color);
						Piece piece2 = new Piece(pieceType, color);
						int x=1;
						if(color.equals(PieceColor.White)){
							Square s1 = new Square(x,2);
							Square s2 = new Square(x,6);
							board.put(s1, piece1);
							board.put(s2, piece2);
						}
					}
				default:
					break;
				}
			}
		}
	}
	
}
