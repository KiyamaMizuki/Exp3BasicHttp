import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.Socket;
public class basic01Server {
    public static void main(String[] args) {
        InetAddress ip;
        try{
            ServerSocket server = new ServerSocket(80);
            while(true){
                System.out.println("サーバーは稼働しています。");
                Socket socket = server.accept();
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                output.println("Hello: BasicHTTP!");
                output.close();     // PrintWriterはclose()で閉じるのが基本
                socket.close();     // Socketはclose()で閉じるのが基本
                ip = InetAddress.getLocalHost();
                System.out.println("Current IP address : " + ip.getHostAddress());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}