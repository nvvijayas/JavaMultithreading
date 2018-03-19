/*
 * Two threads can separately run the two synchronized methods. 
 * One thread calls to addToList1() 
 * Second thread calls to addToList2() 
 * Two threads simultaneously running process()
 * 
 */
package com.epam.multithreading.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeaparateLocking {
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static Object lock1 = new Object();
	static Object lock2 = new Object();

	public static void main(String[] args) {
		System.out.println("Starting");
		long starttime = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
		});
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long endtime = System.currentTimeMillis();
		System.out.println("List 1 size:" + list1.size());
		System.out.println("List 2 size:" + list2.size());
		System.out.println("Time Taken:" + (endtime - starttime));
	}

	private static void addToList1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(new Random().nextInt(100));
		}
	}

	private static void addToList2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(new Random().nextInt(100));
		}

	}

	private static void process() {
		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}

	}

}
