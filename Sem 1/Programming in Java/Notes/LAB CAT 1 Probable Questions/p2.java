/*
 *  VIT Alumni Association invite alumni’s to donate under VITians for VITians fund raising scheme. Create the following classes to 
 *  track it. Create a class by name Alumni with instance members – Name, Year of graduation, amount to donate. Include a parameterized
 *  constructor to initialize the instance members of the class and a display method. Create a main class that reads input values for 
 *  the name, year of graduation and amount to donate, validate the alumni details using the following conditions and throw an 
 *  appropriate user defined exception if the conditions are not met. Else create an object of type Alumni and display back the 
 *  details.  If year of graduation is not between 1988 and 2023, raise InvalidYearException.  If the amount to donate is less 
 *  than 0, raise InvalidAmountException.
 */

import java.util.Scanner;

class InvalidYearException extends Exception {
    @Override
    public String toString() {
        return "Invalid Year detected!";
    }
}

class InvalidAmountException extends Exception {
    @Override
    public String toString() {
        return "Amount can't be less than zero!";
    }
}

class Alumni {
    String Name;
    int year, donation;

    public Alumni(String Name, int year, int donation) {
        this.Name = Name;
        this.donation = donation;
        this.year = year;
    }

    public void display() {
        System.out.println("\n------Alumni Details------");
        System.out.println("Name: " + Name + "\nYear of Graduation: " + year + "\nDonation: " + donation);
    }
}

public class p2 {
    public static void main(String args[]) {
        int amt = 0, year = 0;
        String Name = "";
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the alumni: ");
            Name = sc.nextLine();
            System.out.print("Enter the year of graduation: ");
            year = sc.nextInt();
            if (year < 1988 || year > 2023) {
                throw new InvalidYearException();
            }
            System.out.print("Enter the amount being donated: ");
            amt = sc.nextInt();
            if (amt < 0) {
                throw new InvalidAmountException();
            }
            Alumni al = new Alumni(Name, year, amt);
            al.display();
        } catch (InvalidAmountException e) {
            System.out.println(e.toString());
        } catch (InvalidYearException e) {
            System.out.println(e.toString());
        }
    }
}
