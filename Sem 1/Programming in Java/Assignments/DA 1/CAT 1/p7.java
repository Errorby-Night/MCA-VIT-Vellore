/* Create a class by name STUDENT with instance variables - Register Number, Name and CGPA. The class also should include the following methods:
 * a) Default and parameterized constructors to initialize the instance members.
 * b) Static method highestCGPA() that takes an array of objects of type STUDENT and display the details of the student with the highest CGPA.
 * c) Static method display() that takes an array of objects of type STUDENT and display the above details of all the students whose name begin with 'A'
 * d) Static method above9CGPA() that takes an array of objects of type STUDENT and display the details of all the students whose CGPA is greater than 9
 * Write a main method to test all the above functions
 */

import java.util.*;
class STUDENT{
    int reg;
    String Name;
    double cgpa;
    public STUDENT(){
        reg=0;
        Name="";
        cgpa = 0.0;
    }
    public STUDENT(int reg, String Name, double cgpa){
        this.reg = reg;
        this.Name = Name;
        this.cgpa = cgpa;
    }
    public static void highestCGPA(STUDENT arr[]){
        double max = 0.0;
        for(int i = 0; i < arr.length; i++)
            if(arr[i].cgpa > max)
                max = arr[i].cgpa;
        for(int i = 0; i < arr.length; i++)
            if(arr[i].cgpa == max)
                System.out.printf("Registraton Number: %d\nName: %s\nCGPA: %.2f\n", arr[i].reg, arr[i].Name, arr[i].cgpa);
    }
    public static void display(STUDENT s[]){
        for(int i = 0; i < s.length; i++){
            if(s[i].Name.charAt(0) == 'A' || s[i].Name.charAt(0) == 'a')
                System.out.printf("Registraton Number: %d\nName: %s\nCGPA: %.2f\n", s[i].reg, s[i].Name, s[i].cgpa);
        }
    }
    public static void above9CGPA(STUDENT s[]){
        for(int i = 0; i < s.length; i++){
            if(s[i].cgpa >= 9.0)
                System.out.printf("Registraton Number: %d\nName: %s\nCGPA: %.2f\n", s[i].reg, s[i].Name, s[i].cgpa);
        }
    }
}

class p7{
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of students: ");
        n = sc.nextInt();
        STUDENT s[] = new STUDENT[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the details of Student " + (i+1) +": \n");
            System.out.println("Registration:");
            int reg = sc.nextInt();
            sc.nextLine();
            System.out.println("Name:");
            String Name = sc.nextLine();
            System.out.println("CGPA");
            double cgpa = sc.nextDouble();
            s[i] = new STUDENT(reg, Name, cgpa);
        }
        STUDENT.highestCGPA(s);
        STUDENT.display(s);
        STUDENT.above9CGPA(s);
        sc.close();
    }
}