import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        long dp[] = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        final int MOD = 1000000009;

        for(int i = 4; i < 1000001; i++){
            dp[i] = (dp[i - 1] + dp[i-2] + dp[i - 3]) % MOD;
        }

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            bw.write(dp[N]+"\n");
        }
        bw.flush();






    }

}
