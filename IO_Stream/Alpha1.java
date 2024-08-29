import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.UTFDataFormatException;
import java.nio.Buffer;

/**
 * Alpha1
 */
public class Alpha1  {

    public static void main(String[] args) throws Exception  {
        File f = new File("nigga.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        String sk ="Hello world";
        byte []b = sk.getBytes();
        String value = new String(b,"o");
        for(byte bs:b){
            System.out.println(bs);
        }
        int y = 0x10;
        bw.write("The quick brown  fox jumps over the lazy dog");
        bw.write(69);

        bw.flush();
        fw.flush();
    }
}