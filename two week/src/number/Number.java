package number;
//import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
public class Number {

	public static<V> void main(String[] args) {
		TestThread thread1=new TestThread(); thread1.setName("线程1"); thread1.start();
		TestThread thread2=new TestThread(); thread2.setName("线程2"); thread2.start();
		TestThread thread3=new TestThread(); thread3.setName("线程3"); thread3.start();
		/**TestThread2 thread21=new TestThread2(); new Thread(thread21).start();
		TestThread2 thread22=new TestThread2(); new Thread(thread22).start();
		TestThread2 thread23=new TestThread2(); new Thread(thread23).start();*/
		/**Callable<V> thread31 = new TestThread3<V>();
		FutureTask<V> task = new FutureTask<V>(thread31);
		Thread thread = new Thread(task);
		thread.start();
		Callable<V> thread32 = new TestThread3<V>();
		FutureTask<V> task2 = new FutureTask<V>(thread32);
		Thread thread2 = new Thread(task2);
		thread2.start();
		Callable<V> thread33 = new TestThread3<V>();
		FutureTask<V> task3 = new FutureTask<V>(thread33);
		Thread thread3 =new Thread(task3);
		thread3.start();*/
	}

}
class TestThread extends Thread {
	static int r = 1;
	public void run() {
		synchronized (TestThread.class) {
			for (int i = 1; i < 60; i++) {
				TestThread.class.notify();
				System.out.println(Thread.currentThread().getName() + " " + r);
				r++;
				try {
					TestThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
 
class TestThread2 implements Runnable {
	static int r = 1;
	public void run() {
		synchronized (TestThread.class) {
			for (int i = 1; i <60; i++) {
				TestThread.class.notify();
				System.out.println(Thread.currentThread().getName() + " " + r);
				r++;
				try {
					TestThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
 
class TestThread3<V> implements Callable<V> {
	static int r = 1;
	public V call() throws Exception {
		synchronized (TestThread.class) {
			for (int i = 1; i < 60; i++) {
				TestThread.class.notify();
				System.out.println(Thread.currentThread().getName() + " " + r);
				r++;
				try {
					TestThread.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}}
