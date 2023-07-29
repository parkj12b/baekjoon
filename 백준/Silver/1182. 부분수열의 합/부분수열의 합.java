import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int[] visit;
    static int answer;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        visit = new int[N];

        arr = new int[N];
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // System.out.println(arr[i]);
        }

        answer = 0;
        search(0, 0);
        System.out.println(answer);
    }

    static void search(int depth, int index){
        // System.out.println(sum);
        if(depth != 0 && sum == S){
            answer++;
        }
        if(depth == N){
            return;
        }
        for(int i = 0; i < N; i++){
            if(visit[i] == 1 || i < index) continue;
            sum += arr[i];
            visit[i] = 1;
            search(depth+1, i);
            visit[i] = 0;
            sum -= arr[i];
        }
    }

}
