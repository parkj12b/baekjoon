import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int S = Integer.parseInt(br.readLine());
        int[][] visit = new int[1100][1100];
        int minAction = 0;
        Deque<Pair> queue = new ArrayDeque<Pair>();

        queue.addLast(new Pair(1,0));

        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Pair p = queue.pollFirst();
                int input = p.input;
                int clipboard = p.clipboard;
                if(input > 1099 || input < 0 || clipboard < 0 || clipboard > 1099 || visit[input][clipboard] == 1){
                    continue;
                }
                if(input == S){
                    break esc;
                }
                visit[input][clipboard] = 1;
                for(int j = 0; j < 3; j++){
                    if(j == 0){
                        queue.add(new Pair(input, input));
                    } else if(j == 1){
                        queue.add(new Pair(input+clipboard, clipboard));
                    } else if(j == 2){
                        queue.add(new Pair(input-1, clipboard));
                    }
                }
            }
            minAction++;
        }
        System.out.println(minAction);

    }

    static class Pair{
        int input, clipboard;

        Pair(int input,int clipboard) {
            this.input = input;
            this.clipboard = clipboard;
        }
    }

}