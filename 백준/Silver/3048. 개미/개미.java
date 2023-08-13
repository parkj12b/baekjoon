import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String s1 = br.readLine();
        String s2 = br.readLine();

        int T = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();
        int counter = 0;
        for(int i = N-1; i >= 0; i--){
            char c = s1.charAt(i);
            list.add(new Pair(c, counter+2*T));
            counter +=2;
        }
        counter = N*2-1;
        for(int i = 0; i < M; i++){
            char c = s2.charAt(i);
            list.add(new Pair(c, counter));
            counter+=2;
        }

        Collections.sort(list, (e1, e2) ->{
            return e1.index - e2.index;
        });
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i).letter);
        }
        System.out.println(sb);
    }
    
    static class Pair{
        char letter;
        int index;

        Pair(char letter, int index){
            this.letter = letter;
            this.index = index;
        }
    }
}