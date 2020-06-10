import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.lang.Object.*;
import java.net.InetSocketAddress;
//import javax.*;
public class basic01Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(80);
            InetAddress addr = InetAddress.getLocalHost();
            while(true){
                System.out.println("サーバーは稼働しています。");  
                Socket socket = server.accept();
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                output.println("Hello: BasicHTTP!");
                output.println("IP Address : " + addr.getHostAddress());
                //in.lines().forEach(System.out::println);
                output.close();     // PrintWriterはclose()で閉じるのが基本
                socket.close();     // Socketはclose()で閉じるのが基本
                
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}