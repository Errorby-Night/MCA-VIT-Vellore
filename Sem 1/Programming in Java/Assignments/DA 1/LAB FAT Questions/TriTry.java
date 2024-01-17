import java.util.*;
public class TriTry extends Triangle implements chkTriangle{

    TriTry(int a, int b, int c){
        super(a, b, c);
    }
    @Override
    public boolean isTriangle(int a, int b, int c){
        return ((a + b) >= c && (b + c) >= a && (a + c) >= b );
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        System.out.println("Enter the three sides of an triangle: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        TriTry ob = new TriTry(a, b, c);
        if(ob.isTriangle(a, b, c)){
            if(a == b && a == c)
                System.out.println("Equilateral Triangle");
            else if(a == b || b == c || a == c)
                System.out.println("Isoceles Triangle");
            else
                System.out.println("Scalene Triangle");
        }
        else
            System.out.println("Not a Triangle");
        sc.close();
    }
}