import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        arr = new int[N];
        search(0);
        bw.flush();
    }

    static void search(int depth) throws IOException{
        if(depth == N){
            for(int i = 0; i < N; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            
            return;
        }
        for(int i = 1; i <= N; i++){
            if(visit[i]){
                continue;
            }
            arr[depth] = i;
            visit[i] = true;
            search(depth+1);
            visit[i] = false;
        }
    }
}
