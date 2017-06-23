package com.edu.abhi.concurrency.threads.sharedresources;

import com.edu.abhi.concurrency.inpractice.annotations.ThreadSafe;

/**
 * The LocalObject instance in this example is not returned from the method, nor
 * is it passed to any other objects that are accessible from outside the
 * someMethod() method. Each thread executing the someMethod() method will
 * create its own LocalObject instance and assign it to the localObject
 * reference. Therefore the use of the LocalObject here is thread safe.
 * 
 * @author abhishekkhare
 *
 */
@ThreadSafe
public class SomeClass {
	public void someMethod() {
		LocalObject localObject = new LocalObject();
		localObject.callMethod();
		method2(localObject);
	}

	public void method2(LocalObject localObject) {
		localObject.setValue("value");
	}
}

class LocalObject {
	public void callMethod() {

	}

	public void setValue(String string) {

	}

}
