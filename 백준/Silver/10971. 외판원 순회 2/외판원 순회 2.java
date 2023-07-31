import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visit;
    static int[] order;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        order = new int[N];

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        search(0);
        System.out.println(min);
    }

    static void search(int depth) throws IOException{
        if(depth == N){
            int counter = 0;
            for(int i = 0; i < N-1; i++){
                if(map[order[i]][order[i+1]] == 0){
                    return;
                }
                counter+=map[order[i]][order[i+1]];
            }
            if(map[order[N-1]][order[0]] == 0){
                return;
            }
            counter+=map[order[N-1]][order[0]];
            if(counter < min){
                min = counter;
            } 
                
            return;
        }
        for(int i = 0; i < N; i++){
            if(visit[i] == true) continue;
            visit[i] = true;
            order[depth] = i;
            search(depth+1);
            visit[i] = false;
        }
    }
}
