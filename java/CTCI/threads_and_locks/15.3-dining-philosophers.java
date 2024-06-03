public class Philosopher extends Thread {
    private int bites = 10;
    private Chopstick lower, higher;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if(left.getNumber() < right.getNumber()) {
            lower = left;
            higher = right;
        } else {
            lower = right;
            higher = left;
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void pickUp() {
        lower.pickUp();
        higher.pickUp();
    }

    public void chew() {...}

    public void putDown() {
        higher.putDown();
        lower.putDown();
    }

    public void run() {
        for(int i = 0; i < bites; i++) {
            eat();
        }
    }
}

public class Chopstick {
    private Lock lock;
    private int number;

    public Chopstick(int n) {
        lock = new ReentrantLock();
        number = n;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getNumber() {
        return number;
    }
}