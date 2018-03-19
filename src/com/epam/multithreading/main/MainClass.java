package com.epam.multithreading.main;

import java.util.Scanner;

import com.epam.multithreading.Threading1;

public class MainClass {
	public static void main(String[] args) {
		Threading1 thread1 = new Threading1();
		thread1.start();
		
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			thread1.shutdown();
		}
	}
	
}
