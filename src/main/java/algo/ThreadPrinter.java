

public class ThreadPrinter {

	public static void main(String[] args) throws Exception {
		Monitor monitor = new Monitor();
		int max = 20;
		Thread t1 = new Thread(new OddPrinter(max, monitor), "THREAD-O");
		Thread t2 = new Thread(new EvenPrinter(max, monitor), "THREAD-E");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("done!!!");
	}
}

class Monitor {

	private boolean isEven;

	public boolean isEven() {
		return isEven;
	}

	public void setEven(boolean isEven) {
		this.isEven = isEven;
	}

}

class OddPrinter implements Runnable {
	private final int max;
	private final Monitor monitor;
	
	public OddPrinter(int max, Monitor monitor) {
		this.max = max;
		this.monitor = monitor;
	}

	public void run() {
		int odd = 1;
		while(odd <= max) {
			synchronized (monitor) {
				while(monitor.isEven()) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"-"+odd);
				odd=odd+2;
				monitor.setEven(true);
				monitor.notify();
			}
		}
	}
}

class EvenPrinter implements Runnable {
	private final int max;
	private final Monitor monitor;
	
	public EvenPrinter(int max, Monitor monitor) {
		this.max = max;
		this.monitor = monitor;
	}

	public void run() {
		int even = 2;
		while(even <= max) {
			synchronized (monitor) {
				while(monitor.isEven() == false) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"-"+even);
				even=even+2;
				monitor.setEven(false);
				monitor.notify();
			}
		}
	}
}