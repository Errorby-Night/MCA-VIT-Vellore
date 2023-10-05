import java.util.*;

class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException(String message) {
        super(message);
    }
}

class p12 {

    private static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            System.out.print("Enter your mobile number: ");
            String mobileNumber = sc.next();

            if (isValidMobileNumber(mobileNumber)) {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Mobile Number: " + mobileNumber);
            } else {
                throw new InvalidMobileNumberException("Invalid mobile number format.");
            }

        } catch (InvalidMobileNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    
}
