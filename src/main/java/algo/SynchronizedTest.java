public class SynchronizedTest {
	
	private String name;
	
	public SynchronizedTest(String name) {
		this.name = name;
	}
	
	public static synchronized void staticSyncMethod() {
		System.out.println("SM1 ");
		System.out.println("SM2 ");
	}
	
	public synchronized void syncMethod() {
		System.out.println(name+"M1 ");
		System.out.println(name+"M2 ");
	}

	public static void main(String[] args) throws Exception {
		SynchronizedTest o1 = new SynchronizedTest("O1");
		Thread t1 = new Thread() {
			@Override
			public void run() {
				o1.syncMethod();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				staticSyncMethod();;
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				staticSyncMethod();
			}
		};
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();

	}

}
