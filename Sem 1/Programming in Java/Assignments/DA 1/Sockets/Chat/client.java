import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class client{
    public static void main(String args[]) throws Exception{
        String msg = "";
        String host = "localhost";
        int port = 6555;
        Socket socket = new Socket(host,port);
        System.out.println("Connection Made to Server!");
        OutputStreamWriter toServer = new OutputStreamWriter(socket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Server: ");
            msg = fromServer.readLine();
            if (msg == null || msg.equalsIgnoreCase("exit")){
                break;
            }
            else{
                System.out.println(msg);
                System.out.print("Client: ");
                msg = fromUser.readLine();
                toServer.write(msg);
                toServer.flush();
                if (msg == null || msg.equalsIgnoreCase("exit")){
                break;
                }
            }
        }
        socket.close();
    }
}