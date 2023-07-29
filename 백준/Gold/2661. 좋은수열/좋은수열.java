import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String min = "";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(reader.readLine());

        search("", 0);
        System.out.println(min);
    }

    static void search(String s, int lastNum){
        if(min != ""){
            return;
        }
        for(int i = 2; i*2 <= s.length(); i++){
            if(s.substring(s.length()-i, s.length()).equals(s.substring(s.length()-i*2, s.length()-i))){
                // System.out.println(s.substring(s.length()-i, s.length()));
                // System.out.println(s.substring(s.length()-i*2, s.length()-i));
                return;
            }
        }
        if(s.length() == N){
            min = s;
            return;
        }
        for(int i = 1; i <= 3; i++){
            if(i == lastNum){
                continue;
            }
            search(s+i, i);
        }
    }

}
