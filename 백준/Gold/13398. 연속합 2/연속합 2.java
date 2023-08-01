import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[100001];
        int[][] dp = new int[100001][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = arr[0];
        for (int i = 0; i < N; i++) {
            dp[i][0] = dp[i][1] = arr[i];
            if (i == 0)
                continue;
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        // for(int i = 0; i < N; i++){
        //     System.out.print(dp[i][0] + " : " + dp[i][1]+"\n");
        // }
        System.out.println(ans);
    }

}
