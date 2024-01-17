class Queue1 extends Thread {
    private int queue;
    private Object lock;

    public Queue1(int q, Object l) {
        queue = q;
        lock = l;
    }

    public void run() {
        while (queue > 0) {
            synchronized (lock) {
                int customersToServe = Math.min(2, queue);
                for (int i = 0; i < customersToServe; i++) {
                    System.out.println("Serving customer " + (i + 1) + " in Queue 1");
                }
                queue -= customersToServe;
                lock.notify();
                try {
                    if (queue > 0) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Queue2 extends Thread {
    private int queue;
    private Object lock;

    public Queue2(int q, Object l) {
        queue = q;
        lock = l;
    }

    public void run() {
        while (queue > 0) {
            synchronized (lock) {
                try {
                    if (queue <= 0) {
                        lock.notify();
                        return;
                    }
                    lock.wait();
                    System.out.println("Serving customer in Queue 2");
                    queue--;
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Bank extends Thread {
    boolean serveredQueue= false;
    public void serveQueue1(int number) {
        try{
            if (serveredQueue) {
                wait();
            }
            int minServe = Math.min(2, number);

            while (number > 0) {
                for (int i = 0; i < minServe; i++) {
                    System.out.println("Queue Served -" + (i + 1));
                }
                number -= minServe;
            }
            notify();
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }

    public void serveQueue2(int number) {
        int minServe = Math.min(2, number);

        while (number > 0) {
            for (int i = 0; i < minServe; i++) {
                System.out.println("Queue Served -" + (i + 1));
            }
            number -= minServe;
        }
    }
}

public class test {
    public static void main(String[] args) {
        Object lock = new Object();
        int q1 = 10;
        int q2 = 8;
        Queue1 a = new Queue1(q1, lock);
        Queue2 b = new Queue2(q2, lock);
        a.start();
        b.start();
    }
}
