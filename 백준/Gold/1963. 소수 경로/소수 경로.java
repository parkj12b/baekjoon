import java.io.*;
import java.util.*;

public class Main {
    static boolean primes[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cflag = 0;

        int n;
        int start;
        int end;
        primes = new boolean[10000];
        for (int i = 2; i < 10000; i++) {
            if (primes[i])
                continue;
            int num = i;
            num += i;
            while (num < 10000) {
                primes[num] = true;
                num += i;
            }
        }

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(solve(start, end));
        }
    }

    static int solve(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[10000];
        int[] count = new int[10000];
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++){
                    if (i == 0 && j == 0) continue;
                    int k = change(num, i, j);
                    if (!primes[k] && !visited[k]){
                        visited[k] = true;
                        q.add(k);
                        count[k] = count[num] + 1;
                    }
                }
            }
        }
        return count[end];
    }

    static int change(int num, int index, int toNum) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(index, (char) (toNum + '0'));
        return Integer.parseInt(sb.toString());
    }
}