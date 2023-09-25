package diningphilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ChopStick {

    private final Lock stick = new ReentrantLock();

    private static int stickCount = 0;
    // private boolean iAmFree = true;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    public boolean tryTake(int delay) throws InterruptedException {
        return stick.tryLock(150, TimeUnit.MILLISECONDS);
    }

    public void release() {
    stick.unlock();
    System.out.println("Stick " + myNumber + " Released");
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
