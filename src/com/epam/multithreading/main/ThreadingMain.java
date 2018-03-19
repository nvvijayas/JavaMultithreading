package com.epam.multithreading.main;

import com.epam.multithreading.Threading;

public class ThreadingMain {
	public static void main(String[] args) {
		Threading thread1 = new Threading();
		Threading thread2 = new Threading();
		Threading thread3 = new Threading();
		
		
		thread3.start();
		thread1.start();
		thread2.start();
		
	}
	
	
	
}
