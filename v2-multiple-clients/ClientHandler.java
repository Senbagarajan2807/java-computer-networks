
import java.io.*;
import java.net.*;
public class ClientHandler implements Runnable{

    private Socket socket;

    ClientHandler(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String name = in.readLine();

            String message = in.readLine();

            System.out.println(
                    name + " says: " + message
            );

            out.println("Message received!");

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
