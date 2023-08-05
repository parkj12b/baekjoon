import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        
        dp = new int[K+1];
        int[][] stuff = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            stuff[i][0] = weight;
            stuff[i][1] = value;

        }

        for(int i = 1; i <= N; i++){
            for(int j = K; j >= 0; j--){
                if(j >= stuff[i][0]){
                    dp[j] = Math.max(dp[j], dp[j-stuff[i][0]] + stuff[i][1]);
                }
            }
        }
            
        // for(int i = 0; i < K+1; i++){
        //     System.out.print(dp[i]+" ");
        // }
        System.out.println(dp[K]);
    }

}