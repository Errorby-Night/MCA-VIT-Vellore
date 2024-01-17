import java.util.Scanner;

public class test {
    public static void main(String args[]){
        int regno, int_mark, end_mark;
        String name, course;
        boolean runit = true;
        Scanner sc = new Scanner(System.in);
        while (runit) {
            try{
                System.out.println("Enter the student's Registration number: ");
                regno=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the student's Name: ");
                name=sc.nextLine();
                System.out.println("Enter the student's Course: ");
                course=sc.nextLine();
                System.out.println("Enter the internal marks obtained by the student in the course: ");
                int_mark=sc.nextInt();
                System.out.println("Enter the external marks obtained by the student in the course: ");
                end_mark=sc.nextInt();
                Student ob = new Student(regno, name, course, int_mark, end_mark);
                ob.isPassFail();
                runit = false;
                System.out.println("Student Passed!");
            }catch(FailedException e){
                System.out.println(e.getMessage());
                System.out.println("Try again");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
