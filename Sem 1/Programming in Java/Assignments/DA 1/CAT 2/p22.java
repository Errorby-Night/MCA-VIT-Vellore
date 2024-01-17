import java.util.Scanner;

class NumberProcessor extends Thread {
    private int startNumber;
    private int endNumber;

    // Constructor to initialize starting and ending numbers
    public NumberProcessor(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public void run() {
        int divisibleBy3Count = 0;
        int divisibleBy5Count = 0;
        int divisibleByBothCount = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                divisibleByBothCount++;
            } else if (i % 3 == 0) {
                divisibleBy3Count++;
            } else if (i % 5 == 0) {
                divisibleBy5Count++;
            }
        }

        System.out.println("Thread " + Thread.currentThread().getId() +
                ":\nDivisible by 3 count: " + divisibleBy3Count +
                ",\nDivisible by 5 count: " + divisibleBy5Count +
                ",\nDivisible by both 3 and 5 count: " + divisibleByBothCount);
    }
}

public class p22 {
    public static void main(String[] args) {
        // Create three objects with different number sets
        Scanner sc = new Scanner(System.in);
        int s, e;
        System.out.println("Enter the starting number: ");
        s = sc.nextInt();
        System.out.println("Enter the ending number: ");
        e = sc.nextInt();
        NumberProcessor ob1 = new NumberProcessor(s, e);
        System.out.println("Enter the starting number: ");
        s = sc.nextInt();
        System.out.println("Enter the ending number: ");
        e = sc.nextInt();
        NumberProcessor ob2 = new NumberProcessor(s, e);
        System.out.println("Enter the starting number: ");
        s = sc.nextInt();
        System.out.println("Enter the ending number: ");
        e = sc.nextInt();
        NumberProcessor ob3 = new NumberProcessor(s, e);
        // Start the threads sequentially
        ob1.start();
        try {
            ob1.join(); // Wait for object1 to finish before starting object2
        } catch (InterruptedException es) {
            es.printStackTrace();
        }

        ob2.start();
        try {
            ob2.join(); // Wait for object2 to finish before starting object3
        } catch (InterruptedException es) {
            es.printStackTrace();
        }

        ob3.start();
        sc.close();
    }
}
