import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, max = 0;
    static int[] arr, nums;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        arr = new int[N];
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        search(0);
        System.out.println(max);
    }

    static void search(int depth) throws IOException{
        if(depth == N){
            int counter = 0;
            for(int i = 0; i < N-1; i++){
                counter+=Math.abs(arr[i]-arr[i+1]);
            }
            if(counter > max){
                max = counter;
            }
            return;
        }
        for(int i = 0; i < N; i++){
            if(visit[i]){
                continue;
            }
            arr[depth] = nums[i];
            visit[i] = true;
            search(depth+1);
            visit[i] = false;
        }
    }
}
