import java.util.*;
import java.io.*;
import java.text.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int numInput = Integer.parseInt(reader.readLine());
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < numInput; i++) {
            set.add(reader.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, (String s1, String s2) -> {
            
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
            
            
            
        });
       
        

        
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        


        reader.close();
        writer.flush();
        writer.close();
}


}

