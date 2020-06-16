import java.net.Socket;
import java.util.Scanner;
public class basic01Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 80);          // localhost server を使用
            Scanner input = new Scanner(socket.getInputStream());
            for(int i = 0;i < 2;i++){
                System.out.println(input.nextLine());
            }
            
            input.close();          // Scannerはclose()で閉じるのが基本
            socket.close();         // Socketはclose()で閉じるのが基本
        } catch (Exception e){
            System.out.println(e);
        }
    }
}