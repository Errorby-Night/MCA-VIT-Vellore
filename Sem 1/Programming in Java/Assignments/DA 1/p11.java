import java.util.*;


interface Exam{
    public abstract int Average(int arr[]);
}

interface Classify{
    public abstract String determineClass(int avg);
}

class Result implements Exam, Classify{
    public int Average(int arr[]){
        int avg = 0;
        for(int i=0 ;i<arr.length ;i++){
            avg += arr[i];
        }
        avg = avg / arr.length;
        return avg;
    }

    public String determineClass(int avg){
        if(avg >= 70)
            return "FIRST CLASS WITH DISTINCTION";
        else if(avg < 70 && avg >= 60)
            return "FIRST CLASS";
        else if(avg <60 &&  avg >= 50)
            return "SECOND CLASS";
        else
            return "NO DIVISION";
    }
}

class p11{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        Result r =new Result ();
        int marks[] = new int[n];
        System.out.println("Enter elements in the array");
        for(int i = 0; i < n; i++){
            marks[i] = sc.nextInt();
        }
        int avg = r.Average(marks);
        System.out.println(r.determineClass(avg));
    }

}
