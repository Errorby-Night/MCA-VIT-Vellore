import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    static boolean isHarshad(int n){
        int sum = 0;
        for(int i = n; i > 0; i /= 10)
            sum += i%10;
        return n % sum == 0;
    }
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(6555);
        System.out.println("Server Started...\nWaiting for Connection...");
        Socket s = ss.accept();
        System.out.println("Connection Established!");
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        int number = input.readInt();
        String harshad = "";
        if(isHarshad(number))
            harshad = "Harshad Number\n";
        else
            harshad = "Not a Harshad Number\n";
        output.writeUTF(harshad);
        ss.close();
        System.out.println("Returned Value!");
    }
}