/* WAP to print this pattern
    1
    1   2   3
    1   2   3   4   5
    1   2   3   4   5   6   7
    1   2   3   4   5
    1   2   3
    1
 */

import java.util.*;
class p3{
    public static void main(String args[]) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the length of the pattern: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i+=2){
            for(int j = 1; j<=i; j++)
                System.out.print(j + "\t");
            System.out.println();
        }
        for(int i = n-2; i > 0; i-=2){
            for(int j = 1; j<=i; j++)
                System.out.print(j + "\t");
            System.out.println();
        }
    }
}