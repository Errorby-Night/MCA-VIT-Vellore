import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class server {
    public static void main(String args[]) throws Exception{
        int port = 6555;
        String msg = "";
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server is running");
        System.out.println("Waiting for client!");
        Socket client = ss.accept();
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter toClient = new PrintWriter(client.getOutputStream()); 
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true) {
            System.out.print("Server:");
            msg = fromServer.readLine();
            if (msg == null || msg.equalsIgnoreCase("exit")) break;
            else{
                toClient.println(msg);
                toClient.flush();
                System.out.print("Client: ");
                msg = fromClient.readLine();
                System.out.println(msg);
                if (msg == null || msg.equalsIgnoreCase("exit")) break;
            }
        }
        ss.close();

    }
}
