import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

        PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in)
        );

        System.out.println("Enter your name: ");
        String name = keyboard.readLine();
        System.out.println("Enter the msg: ");
        String msg = keyboard.readLine();
   
        out.println(name);
        out.println(msg);

        String response = in.readLine();
         System.out.println("Server: " + response);
        

        socket.close();
    }
}