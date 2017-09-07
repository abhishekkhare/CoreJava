package com.edu.abhi.dessignpatterns.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
