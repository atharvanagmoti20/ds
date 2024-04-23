import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    // Method to calculate average time among clients
    public static int calculateAverageTime(List<Integer> clientTimes) {
        int sum = 0;
        for (int time : clientTimes) {
            sum += time;
        }
        return sum / clientTimes.size();
    }

    // Method to synchronize time among clients using the Berkeley Algorithm
    public static int synchronizeTime(List<Integer> clientTimes) {
        int averageTime = calculateAverageTime(clientTimes);
        return averageTime;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Server socket listening on port 12345

        System.out.println("Server is running...");

        List<Integer> clientTimes = new ArrayList<>(); // List to store client local times

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected: " + clientSocket);

            // Create input and output streams for communication with the client
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            // Read client's local times
            for (int i = 0; i < 3; i++) {
                int clientLocalTime = dis.readInt();
                System.out.println("Received local time from client: " + clientLocalTime);
                clientTimes.add(clientLocalTime);
            }

            // Synchronize time
            int synchronizedTime = synchronizeTime(clientTimes); // Using the local time
            clientTimes.clear(); // Clear the list for the next round of client connections

            // Send synchronized time back to the client
            dos.writeInt(synchronizedTime);
            System.out.println("Sent synchronized time to client: " + synchronizedTime);

            // Close streams and socket
            dis.close();
            dos.close();
            clientSocket.close();
        }
    }
}
