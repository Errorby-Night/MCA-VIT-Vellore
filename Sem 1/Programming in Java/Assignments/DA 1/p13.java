import Package1.FacultyPublication;
import Package2.Calculate;
import java.util.*;

class FacultyPublicationPoint extends FacultyPublication implements Calculate{
    FacultyPublicationPoint(String Name, int id, int nop, int noc){
        super(Name, id, nop, noc);
    }
    public void determinePoints(){
        double points = 0.0;
        if(super.noc < 25)
            points = 3.0;
        else if(super.noc > 25  && super.noc < 51)
            points = 5.0;
        else if(super.noc > 50 && super.noc <= 75)
            points = 7.5;
        else if(super.noc > 75 && super.noc <= 100)
            points = 10;
        else
            points = 10 + (((super.noc - 100) / 50) * 2.5);

        super.display();
        System.out.println("Points: " + points);
    }
}

class p13{
    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the name of the faculty: ");
        String name = sc.nextLine();
        System.out.print("Enter the id of the faculty: ");
        int id = sc.nextInt();
        System.out.print("Enter the number of publications of the faculty: ");
        int nop = sc.nextInt();
        System.out.print("Enter the number of citations of the faculty: ");
        int noc = sc.nextInt();

        FacultyPublicationPoint ob = new FacultyPublicationPoint(name, id, nop, noc);
        ob.determinePoints();
    }
}