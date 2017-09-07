package com.edu.abhi.designpatterns.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
