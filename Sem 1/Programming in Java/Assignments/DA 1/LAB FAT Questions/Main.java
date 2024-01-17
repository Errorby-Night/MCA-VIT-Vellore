import java.util.Scanner;
import package1.StraightLine;

public class Main {
    public static void main(String args[]){
        int x1, y1, x2, y2;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x1: ");
        x1 = sc.nextInt();
        System.out.println("Enter y1: ");
        y1 = sc.nextInt();
        System.out.println("Enter x2: ");
        x2 = sc.nextInt();
        System.out.println("Enter y2: ");
        y2 = sc.nextInt();

        StraightLine ob1 = new StraightLine(x1, y1, x2, y2);
        ob1.findSlope();
    }
}
