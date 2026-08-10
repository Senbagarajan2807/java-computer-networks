import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is waiting");

        Socket socket = serverSocket.accept();

        System.out.println("Connection established");

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

        PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

        String name = in.readLine();
        String msg = in.readLine();
        System.out.println(name +" says "+msg);
        out.println("Hi " +name);

        socket.close();
        serverSocket.close();
    }
}