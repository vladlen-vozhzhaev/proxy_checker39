import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class ProxyChecker {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/ip.txt");
            int i;
            String socket = "";
            while ((i=fis.read())!=-1){
                if(i==13) continue;
                else if (i==10) {
                    String ip = socket.split(":")[0];
                    String port = socket.split(":")[1];
                    System.out.println("IP: "+ip+" port: "+port);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            checkProxy(ip, Integer.parseInt(port));
                        }
                    });
                    thread.start();
                    socket = "";
                }else{
                    socket += (char) i;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkProxy(String ip, int port){
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            int i;
            while ((i=is.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println(ip+" - НЕ РАБОТАЕТ");
        }

    }
}
