import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.util.Base64;

public class smtpWithSocketProgramming
{
     private static DataOutputStream dos;

     public static void main(String[] args) throws Exception
     {
          int delay = 1000;
          String user = "edu mail";
          String pass = "edu mail password";
          String username = new String(Base64.getEncoder().encode(user.getBytes()));
          String password = new String(Base64.getEncoder().encode(pass.getBytes())); 
          SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
          SSLSocket sock = (SSLSocket) sslsocketfactory.createSocket("smtp.gmail.com", 465);
          final BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

          dos = new DataOutputStream(sock.getOutputStream());
          
          send("EHLO smtp.gmail.com\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          System.out.println("SERVER: "+br.readLine());
          
          send("AUTH LOGIN\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          
          send(username + "\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          
          send(password + "\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());

          send("MAIL FROM:<s1911176136@ru.ac.bd>\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          
          send("RCPT TO:<ashiqpranto@gmail.com>\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          
          send("DATA\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());
          
          Thread.sleep(delay);
          send("Subject: Email test 1\r\n");
          
          Thread.sleep(delay);
          send("Email body\r\n");
          
          send(".\r\n");
          Thread.sleep(delay);
          System.out.println("SERVER: "+br.readLine());

          send("QUIT\r\n");
     }

     private static void send(String s) throws Exception
     {
          dos.writeBytes(s);
          System.out.println("CLIENT: "+s);
     }
}