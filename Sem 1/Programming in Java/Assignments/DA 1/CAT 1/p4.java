/* WAP to find the max and min of n elements */
import java.util.*;
class p4{
    public static void main(String args[]){
        Scanner sc=new Scanner (System .in);
        int min = 0, max = 0;
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(i == 0){
                max = arr[0];
                min = arr[0];
            }
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println("Max: " + max + "\nMin: " + min);
        sc.close();
    }
}