package com.edu.abhi.designpatterns.observer;

public class GrabStocks{
	
	public static void main(String[] args){
		
		// Create the Subject object
		// It will handle updating all observers 
		// as well as deleting and adding them
		
		StockGrabber stockGrabber = new StockGrabber();
		
		// Create an Observer that will be sent updates from Subject
		
		StockObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(197.01);
		stockGrabber.setAAPLPrice(677.61);
		stockGrabber.setGOOGPrice(676.41);
		
		StockObserver observer2 = new StockObserver(stockGrabber);
		
		stockGrabber.setIBMPrice(197.02);
		stockGrabber.setAAPLPrice(677.62);
		stockGrabber.setGOOGPrice(676.42);
		
		// Delete one of the observers
		
		// stockGrabber.unregister(observer2);
		
		stockGrabber.setIBMPrice(197.03);
		stockGrabber.setAAPLPrice(677.63);
		stockGrabber.setGOOGPrice(676.43);
		
		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste 
		// its one extendable class option
		
		/*Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		/Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);
		
		// Call for the code in run to execute 
		
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();*/
		
		
	}
	
}
