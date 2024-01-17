/* WAP to find the number of occurences of a specific number in a array */
import java.util.*;
class p5{
    public static void main(String args[]){
        Scanner sc=new Scanner (System .in);
        int occ = 0, num;
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to find it's occurence: ");
        num = sc.nextInt();
        for(int i = 0; i < n; i++)
            if(arr[i] == num)
                occ++;
        System.out.print("\nThe element " + num + " was found " + occ +" times.\n\n");
        sc.close();
    }
}