import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegRex{
    public static void main(String[] args) {
        int count =0;
        String name = "22";
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(name);
        while (m.find()) {
            System.out.println(m.start()+"--"+m.end());
        }
        

    }
}