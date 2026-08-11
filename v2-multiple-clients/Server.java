
import java.io.*;
import java.net.*;



public class Server {
        public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(5000);
         System.out.println("Server started...");
        System.out.println("Server is waiting for clients");

        while(true){
            Socket socket = serverSocket.accept();
            ClientHandler ch = new ClientHandler(socket);
            System.out.println("New client connected!");
            Thread thread  = new Thread(ch);
            thread.start();
        }
    
       }
    }
