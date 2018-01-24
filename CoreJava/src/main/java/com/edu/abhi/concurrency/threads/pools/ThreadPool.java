package com.edu.abhi.concurrency.threads.pools;

import com.edu.abhi.concurrency.threads.blockingQueue.BlockingQueueA;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private BlockingQueueA taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueueA(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }
    
    public static void main(String [] args) throws Exception{
    	ThreadPool t = new ThreadPool(10,2);
    	for (int i = 0; i < 10; i++) {
			t.execute(new MyPoolRunnable(i));
		}
    }

}

class MyPoolRunnable implements Runnable{
	int i;
	public MyPoolRunnable(int i){
		this.i =i;
	}
	@Override
	public void run() {
		System.out.println("Running Thread Name ::" + Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "MyPoolRunnable [i=" + i + "]";
	}
	
	
}