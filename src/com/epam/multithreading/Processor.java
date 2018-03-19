package com.epam.multithreading;

public class Processor {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("In Produccer");
			wait();
			System.out.println("in producer after wait and notify");
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized (this) {
			System.out.println("In consumer");
			notify();
			Thread.sleep(5000);
		}
		
	}

}
