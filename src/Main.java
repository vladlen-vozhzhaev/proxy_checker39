import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C://java/test.txt");
            int i;
            while ((i = fis.read()) != -1){
                System.out.print((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*String text = "\nHello world";
        try {
            FileOutputStream fos = new FileOutputStream("C://java/test.txt", true);
            byte[] buffer = text.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}