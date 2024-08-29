import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * FileOrNot
 */
public class FileOrNot {

    public static void main(String[] args)  throws Exception{
        File f = new File("new.txt");
        Scanner sc =  new Scanner(System.in);;
        FileWriter fw = new FileWriter(f);
        
        ArrayList <Integer> r = new ArrayList<>();
        int n =-2;
        while (n!=-1) {
            System.out.println("type");
            n=sc.nextInt();
            fw.write(""+n+"\n");;
            
        }
        fw.close();
        FileReader fr1 = new FileReader(f);
        BufferedReader br = new BufferedReader(fr1);
        String line = br.readLine();
        while (line!=null) {
            r.add(Integer.parseInt(line));
            line=br.readLine();
        }
        br.close();
        fr1.close();;
        Collections.sort(r);
        System.out.println(r);
         
        FileWriter fr = new FileWriter("copy.txt");
        BufferedWriter bw = new BufferedWriter(fr);
        for (Integer integer : r) {
            bw.write(integer+"\n");
            }
            bw.close();
            fr.close();


    }
}