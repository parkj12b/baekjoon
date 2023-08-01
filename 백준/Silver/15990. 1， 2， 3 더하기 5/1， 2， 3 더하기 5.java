import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        int[][] dp = new int[100001][4];
    
        final int MOD = 1000000009;

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        for(int i = 3; i <= 100000; i++){
            dp[i][1] += (dp[i-1][2] + dp[i-1][3]) % MOD; 
            dp[i][2] += (dp[i-2][1] + dp[i-2][3]) % MOD; 
            dp[i][3] += (dp[i-3][1] + dp[i-3][2]) % MOD; 
        }

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int counter = 0;

            for(int j = 1; j <= 3; j++){
                counter = (counter + dp[N][j])  % MOD;
            }
            bw.write(counter+"\n");
        }
        bw.flush();

    }

}
