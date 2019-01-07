https://www.tutorialspoint.com/java_concurrency/concurrency_overview.htm
**LOCK**
A java.util.concurrent.locks.Lock interface is used to as a thread synchronization mechanism similar to synchronized blocks. New Locking mechanism is more flexible and provides more options than a synchronized block. Main differences between a Lock and a synchronized block are following −

Guarantee of sequence − Synchronized block does not provide any guarantee of sequence in which waiting thread will be given access. Lock interface handles it. - ?????

No timeout − Synchronized block has no option of timeout if lock is not granted. Lock interface provides such option.

Single method − Synchronized block must be fully contained within a single method whereas a lock interface's methods lock() and unlock() can be called in different methods.

1. lock() - Acquires the lock.
2. lockInterruptibly() - Acquires the lock unless the current thread is interrupted.
3. newCondition() - Returns a new Condition instance that is bound to this Lock instance.
4. tryLock() - Acquires the lock only if it is free at the time of invocation.
5. tryLock() - Acquires the lock only if it is free at the time of invocation.
6. tryLock(long time, TimeUnit unit) - Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
7. unlock() - Releases the lock.

**LOCK CONDITION**

A java.util.concurrent.locks.Condition interface provides a thread ability to suspend its execution, until the given condition is true. A Condition object is necessarily bound to a Lock and to be obtained using the newCondition() method.

1. await() - Causes the current thread to wait until it is signaled or interrupted.
2. signal() - Wakes up one waiting thread. 

**Executor Interface**

- java.util.concurrent.Executor
- java.util.concurrent.ExecutorService - interface is a sub interface of Executor interface, and adds features to manage the life cycle, both of the individual tasks and of the executor itself.
- A java.util.concurrent.ScheduledExecutorService interface is a sub interface of ExecutorService interface, and supports future and/or periodic execution of tasks.

**Thread Pool**
newFixedThreadPool(n)
- Maximum n threads will be active to process tasks.
- If more than n threads are submitted then they are held in a queue until threads become available.
- A new thread is created to take its place if a thread terminates due to failure during execution shutdown on executor is not yet called.

newCachedThreadPool() 
- an executor having an expandable thread pool.
- Such an executor is suitable for applications that launch many short-lived tasks.

newScheduledThreadPool()


**Futures and Callables**
java.util.concurrent.Callable object can return the computed result done by a thread in contrast to runnable interface which can only run the thread. The Callable object returns Future object which provides methods to monitor the progress of a task being executed by a thread. Future object can be used to check the status of a Callable and then retrieve the result from the Callable once the thread is done. It also provides timeout functionality.



