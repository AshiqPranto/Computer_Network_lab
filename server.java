import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) {
        
        try {
            
            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = serverSocket.accept();
            
            // InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // String fromClient = bufferedReader.readLine();
            String fromClient = (String)dis.readUTF();
            System.out.println(fromClient);
            serverSocket.close(); 

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}