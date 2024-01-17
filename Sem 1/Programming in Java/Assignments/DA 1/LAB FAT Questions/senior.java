import java.util.*;

class SeniorHalf extends Thread{

    private int array[];

    public SeniorHalf(int array[]){
        this.array=array;
    }
    public void run(){
        int count = 0;
        for(int i = 0; i < 1000; i++){
            if(array[i] >= 60)
                count++;
        }
        System.out.println("The number of senior citizens in the first half of the array: " + count);
    }
}

class SeniorHalf2 extends Thread{

    private int array[];

    public SeniorHalf2(int array[]){
        this.array=array;
    }
    public void run(){
        int count = 0;
        for(int i = 1000; i < 2000; i++){
            if(array[i] >= 60)
                count++;
        }
        System.out.println("The number of senior citizens in the second half of the array: " + count);
    }
}

public class senior {

    public static void main(String args[]) throws Exception{
        int patients[] = new int[2000];

        for(int i = 0; i < 2000; i++)
            patients[i] = (int)(Math.random() * 100);
        
        SeniorHalf t1 = new SeniorHalf(patients);
        SeniorHalf2 t2 = new SeniorHalf2(patients);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
