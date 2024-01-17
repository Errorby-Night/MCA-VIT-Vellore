import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Setup input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Prompt for messages and send to the client
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String serverMessage;
            while (true) {
                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                out.println(serverMessage);

                if ("exit".equalsIgnoreCase(serverMessage)) {
                    break;
                }

                // Receive client's message
                String clientMessage = in.readLine();
                System.out.println("Client: " + clientMessage);

                if ("exit".equalsIgnoreCase(clientMessage)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
