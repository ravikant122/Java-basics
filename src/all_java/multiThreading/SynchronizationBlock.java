package all_java.multiThreading;

class Employee {
	private int id;
	private int deptId;
	private String name;
	public Employee(int id, int deptId, String name) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// whole method is synchronized, if one thread enters in this method, other threads have to wait
	// but if only some lines access the shared resources, then we should not use method level synchronization
	// we should use block level sync
	public synchronized void increaseIdMethodSync() {
		this.setDeptId(deptId + 1);
	}
	/*
		this is same as above method, 
		public void method() {
			synchronized (this) {
				//
			}
		}
		above code is same as 
		public synchronized void method() {
			//
		}
		
		one reason to avoid locking using this
	 */
	public void increaseIdMethodSyncUsingThis() {
		synchronized (this) {
			this.setDeptId(deptId + 1);
		}
	}
	
	// one more reason to avoid locking using this because method1 and method2 can be executed concurrently
	// there's no race condition but they can't because both have lock on this, so they will get executed
	// one after the other, not the best use of resources like CPU
	public void method1() {
	    // do something ...
	    synchronized(this) {
	        id++;      
	    }
	    // ................
	}
	public void method2() {
	    // do something ...
	    synchronized(this) {
	        deptId++;      
	    }
	    // ................
	}
	// one more reason is that outside this class, some other class can access your object means this
	// so more unncessary locking
	
	static Object lock = new Object();
	public void method3() {
		
		// this is local variale to this method and threads have their own callstack means lock is local
		// to the thread means if two thread call this method, they will have different copy of lock1's
		// variables but not its object as getLockObject always returns the same object
		// and synchronized(lock1) is actually synchronized(lock1's object) 
		// even though lock1 are different for diff thread as they are local variable
		// but lock1's object is created only once, its memory is created once
		// that's why it will be locked here
		Object lock1 = getLockObject();
		synchronized (lock1) {
			// accessign some share resource here
		}
	}
	public static Object getLockObject() {
		return lock;
	}
}

public class SynchronizationBlock {
	public static void main(String[] args) {
		// synchronization can be acheived using synchroninzing a method or a block
		
		// synchronization method, this should be avoided becuase it block the other threads from entering
		// in the method even if there's only a few lines that uses shared resources
		// means we should put lock on those lines, not the whole method
		
		// synchronization block, synchronized(some object reference)
		// object reference can be 'this' or A.class or some private local object of some class
		// we can't use primitive type(int, float) in Java
		
		// this should be avoided, reason explained above
		
		// A.class should also be avoided because it also block threads from working concurrently
		// even if there's no race condition
		
		// using private local object's reference is the best
		// generally we create it like this - private final Object lock = new Object();
		// and use it like this - synchronized(lock)
		
		// this to note is, synchronization is happening on the lock object, we are just using its reference
		// and means synchronized(lock) = synchronized(new Object())
		// lock is not synchronized, means other threads can change the lock's reference
		// lets say there are two locks, lock1 and lock2 - both are being used in synchronization
		// inside synchronized(lock1) - it change the reference of lock2
		// even if it changes the reference of lock2 - the block of lock2 is safe as the lock was on
		// synchronized(new Object() // lock2's object), we were just using lock2 as reference to its object
		// but your lock should be final because it shouldn't changed and its only purpose it locking
		// so we shouldn't change it
		
		// special case about String - String are created in String pool and they are constants
		// so if we create a string - String lock = "lock" and use it synchronized(lock)
		// then it will synchronized well, because lock is constant and no thread can enter
		// if we create another string - String lock2 = "lock"
		// if we use synchronized(lock2) somewhere else then also no thread can enter as we are locking
		// using "lock" string(not its referenced variables) which is constant means only one in String pool
		// but this is not recommanded as whenever someone uses "lock" string, we are blocking ourselves
	}
}
