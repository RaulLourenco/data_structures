//Single threaded
void fizzbuzz(int n) {
    for(int i = 1; i <= n; i++) {
        if(i % 3 == 0 && i % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if(i % 3 == 0) {
            System.out.println("Fizz");
        } else if(i % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }
}

//Multithreaded
int n = 100;
Thread[] threads = {
    new FizzBuzzThread(i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz", n),
    new FizzBuzzThread(i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", n),
    new FizzBuzzThread(i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", n),
    new FizzBuzzThread(i -> i % 3 != 0 && i % 5 != 0, i -> Integer.toString(i), n)
};

for(Thread thread : threads) {
    thread.start();
}

public class FizzBuzzThread extends Thread {
    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private Predicate<Integer> validate;
    private Function<Integer, String> printer;

    public FizzBuzzThread(Predicate<Integer> validate, 
                          Function<Integer, String> printer, 
                          int max) {
        this.validate = validate;
        this.printer = printer;
        this.max = max;
    }

    public void run() {
        while(true) {
            synchronized(lock) {
                if(current > max) {
                    return; 
                }

                if(validate.test(current)) {
                    System.out.println(printer.apply(current));
                    current++;
                }
            }
        }
    }
}