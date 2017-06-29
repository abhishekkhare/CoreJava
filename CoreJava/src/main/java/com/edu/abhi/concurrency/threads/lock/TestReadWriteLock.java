package com.edu.abhi.concurrency.threads.lock;

public class TestReadWriteLock {
	ReadWriteLock lock = new ReadWriteLock();
	private int readCount = 0;
	private int writeCount = 0;
	
	public void read() throws InterruptedException{
		lock.lockRead();
		System.out.println(Thread.currentThread().getName() + "::READ::ReadCount" + ++readCount + "WriteCount" + writeCount);
		lock.unlockRead();
	}
	
	public void write() throws InterruptedException{
		lock.lockWrite();
		System.out.println(Thread.currentThread().getName() + "::WRITE::ReadCount" + readCount + "WriteCount" + ++writeCount);
		lock.unlockWrite();
	}
	
	public static void main(String[] args) {
		TestReadWriteLock t = new TestReadWriteLock();
		for (int i = 0; i < 5; i++) {
			MyRunnableRead r = new MyRunnableRead(t);
			Thread th1 = new Thread(r,"R"+i);
			if(i%2==0){
				MyRunnableWrite w = new MyRunnableWrite(t);
				Thread th2 = new Thread(w,"W"+i);
				th1.start();
				th2.start();
			}else{
				th1.start();
			}
		}
	}
}

class MyRunnableRead implements Runnable{
	TestReadWriteLock tt;
	public MyRunnableRead(TestReadWriteLock t ){
		this.tt=t;
	}
	@Override
	public void run() {
		try {
			tt.read();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}

class MyRunnableWrite implements Runnable{
	TestReadWriteLock tt;
	public MyRunnableWrite(TestReadWriteLock t ){
		this.tt=t;
	}
	@Override
	public void run() {
		try {
			tt.write();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}