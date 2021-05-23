package com.accolite.au.y2021.mt.evaluation.himanshu.q3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
class Deadlock{
	static final String r1 = "Resouce1";
   	static final String r2 = "Resouce2";
	public static class Thread1 implements Callable<String>{
	   @Override
	   public String call() throws Exception {
		   synchronized(r1){
				System.out.println("Thread 1: Locked r1");
				try{ 
					Thread.sleep(100);
				}
				catch(Exception e) {}
		  		synchronized(r2){
					System.out.println("Thread 1: Locked r2");
				}
		 	}
		 	return "grbg";

		}
	}
	public static class Thread2 implements Callable<String>{
		@Override
		public String call() throws Exception {
			synchronized(r2){
				System.out.println("Thread 2: Locked r2");
				try{ 
					Thread.sleep(100);
				} 
				catch(Exception e) {}
		   		synchronized(r1){
		   			System.out.println("Thread 2: Locked r1");
		   		}
		   }
		   return "grbg";
		}
	}
}
public class Main{
	public static void main(String[] args){
		Deadlock.Thread1 t1 = new Deadlock.Thread1();
		Deadlock.Thread2 t2 = new Deadlock.Thread2();
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String> f1 = ex.submit(t1);
		Future<String> f2 = ex.submit(t2);
	}
}