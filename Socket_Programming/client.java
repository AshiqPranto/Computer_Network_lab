import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket socket = new Socket("localhost",5555);
        
        // DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        // PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        // printWriter.println("Hello");

        DataOutputStream douts = new DataOutputStream(socket.getOutputStream());

        douts.writeUTF("hello from utf");
        douts.flush();
        douts.close();
        socket.close();
    }

}
