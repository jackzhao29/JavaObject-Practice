package com.coldface.code.concurrent;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayExample {
	private static AtomicIntegerArray at = new AtomicIntegerArray(10);

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i < at.length(); i++) {
			at.set(i, 1);
		}
		Thread t1 = new Thread(new AddFive());
		Thread t2 = new Thread(new Increment());
		Thread t3=new Thread(new Compare());
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out
				.println("All threads are finished. AtomicInteger array's values are :");
		for (int i = 0; i < at.length(); i++) {
			System.out.println(i + "-" + at.get(i));
		}

	}

	static class AddFive implements Runnable {
		public void run() {
			for (int i = 0; i < at.length(); i++) {
				int addFile = at.addAndGet(i, 5);
				System.out.println("Thread:" + Thread.currentThread().getId()
						+ " / adding five ,at" + i + "position:" + addFile);
			}
			System.out.println("Thread" + Thread.currentThread().getId()
					+ " /array now is :" + at);
		}
	}

	static class Increment implements Runnable {
		public void run() {
			for (int i = 0; i < at.length(); i++) {
				int add = at.incrementAndGet(i);
				System.out.println(" Thread:" + Thread.currentThread().getId()
						+ "/ increasing,at " + i + " position:" + add);
			}
			System.out.println("Thread:" + Thread.currentThread().getId()
					+ " / array now is:" + at);
		}
	}

	static class Compare implements Runnable {
		public void run() {
			for (int i = 0; i < at.length(); i++) {
				boolean isFive = at.compareAndSet(i, 5, 3);
				System.out.println("Thread " + Thread.currentThread().getId()
						+ " / comparing value to 5,result is:" + isFive
						+ ",so at:" + i + "position:" + at.get(i));
			}
			System.out.println("Thread " + Thread.currentThread().getId()
					+ " / array now is " + at);

		}
	}

}
