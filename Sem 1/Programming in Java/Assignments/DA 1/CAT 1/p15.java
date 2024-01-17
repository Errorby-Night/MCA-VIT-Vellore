import java.util.Random;

class Thread1 extends Thread {
    int low, high, max;
    int[] a;

    Thread1(int[] a, int low, int high) {
        this.low = low;
        this.high = high;
        this.a = a;
        max = a[low];
        start();
    }

    void findMax() {
        for (int i = low + 1; i <= high; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
    }

    public void run() {
        findMax();
    }
}

public class p15 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[1000];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(2000);
        }
        
        Thread1 t1 = new Thread1(array, 0, 499);
        Thread1 t2 = new Thread1(array, 500, 999);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        if (t1.max > t2.max) {
            System.out.println("Max: " + t1.max);
        } else {
            System.out.println("Max: " + t2.max);
        }
    }
}
