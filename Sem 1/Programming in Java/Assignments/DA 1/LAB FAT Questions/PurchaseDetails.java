import java.io.*;
import java.util.Scanner;

class PurchaseDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int grocery_id[];

    PurchaseDetails() {
    }

    PurchaseDetails(String name, int grocery_id[]) {
        this.name = name;
        this.grocery_id = grocery_id;
    }

    void writeToFile() throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("grocery.ser")))) {
            int n;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of customers: ");
            n = sc.nextInt();

            PurchaseDetails customers[] = new PurchaseDetails[n];
            for (int i = 0; i < n; i++) {
                System.out.print("\nCustomer " + (i + 1) + ":\n");
                System.out.println("Name : ");
                customers[i] = new PurchaseDetails();
                sc.nextLine();
                customers[i].name = sc.nextLine();
                System.out.println("Grocery ID's : ");
                int m = sc.nextInt();
                int arr[] = new int[m];
                for (int j = 0; j < m; j++) {
                    arr[j] = sc.nextInt();
                }
                customers[i].grocery_id = arr;
            }

            oos.writeObject(customers);
        }
    }

    void readFromFile() throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("grocery.ser")))) {
            PurchaseDetails customers[] = (PurchaseDetails[]) ois.readObject();

            // Displaying read data
            for (int i = 0; i < customers.length; i++) {
                System.out.println("\nCustomer " + (i + 1) + ":");
                System.out.println("Name: " + customers[i].name);
                System.out.print("Grocery ID's: ");
                for (int id : customers[i].grocery_id) {
                    System.out.print(id + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String args[]) throws Exception {
        PurchaseDetails ob = new PurchaseDetails();
        ob.writeToFile();
        ob.readFromFile();
    }
}
