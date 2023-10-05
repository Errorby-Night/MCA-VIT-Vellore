/*WAP to perform the basic arithmetic operations using switch. (Operators should be read as string).*/
import java.util.*;
class p2{
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the first number");
        double n1 = sc.nextDouble();
        System.out.println("Enter the second number");
        double n2 = sc.nextDouble();
        System.out.println("Enter the operation you want to perform:");
        String op = sc.next();
        double result = 0.0;
        switch(op){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if(n2 != 0)
                    result = n1 / n2;
                else
                    System.out.println("Can't divide by zero!");
                break;
        }
        System.out.printf("Result: %.2f", result);
        
    }
}