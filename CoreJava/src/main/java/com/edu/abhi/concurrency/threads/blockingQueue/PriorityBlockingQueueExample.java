package com.edu.abhi.concurrency.threads.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		final ExecutorService service = Executors.newFixedThreadPool(2);
		final BlockingQueue<Document> bqueue = new PriorityBlockingQueue<Document>();
		service.execute(new AddDocumentThread(bqueue));
		service.execute(new PrintDocumentThread(bqueue));
		//Thread.sleep(10000);
		service.execute(new AddDocumentThread(bqueue));
		service.shutdown();
	}

}

class AddDocumentThread implements Runnable {
	BlockingQueue<Document> bqueue;

	public AddDocumentThread(BlockingQueue<Document> bqueue) {
		this.bqueue = bqueue;
	}

	@Override
	public void run() {
		bqueue.offer(new Document(3, "FRDE"));
		bqueue.offer(new Document(5, "GTGT"));
		bqueue.offer(new Document(1, "AFSD"));
		bqueue.offer(new Document(2, "HGTF"));
		bqueue.offer(new Document(4, "BGTF"));
		
	}
}

class PrintDocumentThread implements Runnable {
	BlockingQueue<Document> bqueue;

	public PrintDocumentThread(BlockingQueue<Document> bqueue) {
		this.bqueue = bqueue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			while (true) {
				Document doc = bqueue.take();
				System.out.println(doc.getDocName() + " with id:" + doc.getDocId() + " printed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Document implements Comparable<Document> {
	private int docId;
	private String docName;

	public Document(int bookId, String bookName) {
		this.docId = bookId;
		this.docName = bookName;
	}

	public int getDocId() {
		return docId;
	}

	public String getDocName() {
		return docName;
	}

	@Override
	public int compareTo(Document ob) {
		return docName.compareTo(ob.getDocName());
	}
}