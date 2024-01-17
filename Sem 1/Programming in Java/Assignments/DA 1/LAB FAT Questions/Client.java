import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;


class Client{
    public static void main(String args[]) throws Exception{
        
        Socket s = new Socket("localhost", 6555);
        System.out.println("Connected to server");
        DataInputStream input = new DataInputStream(s.getInputStream());
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number: ");
        int num = Integer.parseInt(br.readLine());
        output.writeInt(num);
        String harshad = input.readUTF();
        System.out.println(harshad);
        s.close();
    }
}