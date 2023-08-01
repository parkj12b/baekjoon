import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[31];
        int[] dp2 = new int[31];

        dp[2] = 3;
        dp[4] = 11;
        dp2[4] = 6;
        int mod = 1000000007;
        for(int i = 6; i <= N; i+=2){
            dp[i] = (dp[i-2]*3 + dp2[i-2] + 2) % mod;
            dp2[i] = (dp[i-2]*2+ dp2[i-2])% mod;
        }

        System.out.println(dp[N]);
    }

}
