import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            // Setup input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Prompt for messages and send to the server
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage;
            while (true) {
                System.out.print("Client: ");
                clientMessage = consoleInput.readLine();
                out.println(clientMessage);

                if ("exit".equalsIgnoreCase(clientMessage)) {
                    break;
                }

                // Receive server's message
                String serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);

                if ("exit".equalsIgnoreCase(serverMessage)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
