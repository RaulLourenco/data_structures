public class Foo {
    public Semaphore sem1, sem2;

    public Foo() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(2);

            sem1.acquire();
            sem2.acquire();
        } catch(...) {...}
    }

    public void first() {
        try {
            sem1.release();
        } catch(...) {...}
    }

    
    public void second() {
        try {
            sem1.acquire();
            sem1.release();
            ...
            sem2.release();
        } catch(...) {...}
    }

    
    public void third() {
        try {
            sem2.acquire();
            sem2.release();
            ...
        } catch(...) {...}
    }
}