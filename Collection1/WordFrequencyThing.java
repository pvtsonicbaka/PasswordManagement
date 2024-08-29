import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * WordFrequencyThing
 */

public class WordFrequencyThing {
    public static void main(String[] args) throws Exception {
        File f = new File("new.txt");
        FileReader fr = new FileReader(f);
        BufferedReader bf = new BufferedReader(fr);
        String line= bf.readLine();
        HashMap<String,Integer > map = new HashMap();
        while(line!=null){
            String word[] = line.split(" ");
            for(String sk: word){
                if(map.containsKey(sk)){
                    map.put(sk,map.get(sk)+1);
                    }else{
                        map.put(sk,1);
                        }
            }
            line = bf.readLine();

        }
        System.out.println("diplay toal words and their freq");
        for(Map.Entry  e: map.entrySet()){
            System.out.println(e.getValue()+" "+e.getKey());
            }
        bf.close();
        fr.close();

    }
    
}