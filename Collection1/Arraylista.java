


import java.util.ArrayList;
// import java.util.Collection;
import java.util.Collections;

public class Arraylista {
    
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(100);
        a.add(102);
        a.add(103);
        a.add(104);
        a.add(105);
        System.out.println(a.size());

        System.out.println(a.set(2,5));
        a.remove(0);
        
        System.out.println(a.size());
        Collections.sort(a);
        Collections.reverseOrder();
        System.out.println(a);  
    }
}
