import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args) throws IOException {
        System.out.println("Server");
        int PORT = 25565;
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Новое соединение accepted");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if(serverSocket !=null){
                    serverSocket.close();
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
