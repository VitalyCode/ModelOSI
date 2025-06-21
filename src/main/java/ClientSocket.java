import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[]args){
        System.out.println("Client");
        String host = "localhost";
        int port = 25565;
        try(Socket clientSocket = new Socket(host,port)){
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("GET/HTTP/1.1 \n"+"Host: netology.ru");
            String resp = in.readLine();
            System.out.println(resp);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
