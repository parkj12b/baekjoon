import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] array = new int[N+1][2]; 
        
        dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(reader.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= K; j++){
                if(array[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-array[i][0]]+array[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

}