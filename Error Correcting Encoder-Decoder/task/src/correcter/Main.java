package correcter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String fileSend = "send.txt";
        String fileReceived = "received.txt";

        File file = new File("send.txt");
        byte[] bytesArray = new byte[(int) file.length()];

        // Open txt file, then read in as byte stream
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytesArray);
        } catch (Exception e) {
            System.out.println("Exception FileInputStream: " + e);
        }

        Random random = new Random();
        // Change byte
        for (int i = 0; i < bytesArray.length; i++) {
            bytesArray[i] ^= 1 << random.nextInt(8);
        }

        // Read byte stream, then write out to file
        try (FileOutputStream fos = new FileOutputStream(fileReceived);) {
            fos.write(bytesArray);
        } catch (Exception e) {
            System.out.println("Exception FileOutputStream: " + e);
        }
    }
}

