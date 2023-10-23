import java.util.Scanner;

class Tribonacci extends Thread {
    int n;
    int count;

    Tribonacci(int n) {
        this.n = n;
        count = 0;
        start();
    }

    void tribonacci(int n1, int n2, int n3) {
        int sum = n1 + n2 + n3;
        while (count < n - 3) {
            System.out.print(sum + " "); // Print without a newline to display the sequence on one line
            count++;
            tribonacci(n2, n3, sum);
        }
    }

    public void run() {
        System.out.println("TRIBONACCI -> ");
        System.out.print(0 + " "); // Print the initial values on one line
        System.out.print(1 + " ");
        System.out.print(1 + " ");
        tribonacci(0, 1, 1);
        System.out.println(); // Print a newline after the sequence is complete
    }
}

class Fibonacci extends Thread {
    int n;
    int count;

    Fibonacci(int n) {
        this.n = n;
        count = 0;
        start();
    }

    void fibonacci(int n1, int n2) {
        int sum = n1 + n2;
        while (count < n - 2) {
            System.out.print(sum + " "); // Print without a newline to display the sequence on one line
            count++;
            fibonacci(n2, sum);
        }
    }

    public void run() {
        System.out.println("FIBONACCI -> ");
        System.out.print(0 + " "); // Print the initial values on one line
        System.out.print(1 + " ");
        fibonacci(0, 1);
        System.out.println(); // Print a newline after the sequence is complete
    }
}

public class p14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements: ");
        n = sc.nextInt();
        Fibonacci f = new Fibonacci(n);
        try {
            f.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        Tribonacci t = new Tribonacci(n);
    }
}
