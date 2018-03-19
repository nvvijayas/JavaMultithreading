package com.epam.multithreading.main;

import java.util.Scanner;

import com.epam.multithreading.Volatile;

public class VolatileMain {
	public static void main(String[] args) {
		Volatile vol = new Volatile();
//		Thread thread = new Thread(vol);
		vol.start();
		System.out.println("Press any button to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		vol.shutdown();
	}

}
