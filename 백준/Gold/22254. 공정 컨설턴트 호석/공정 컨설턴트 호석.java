import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, X;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 1;
        int max = N;
        int sum = 0;
        int answer = 0;

        while (min <= max){
            int mid = (min + max) / 2;
            int flag = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < mid; i++){
                pq.add(0);
            }
            for(int i = 0; i < N; i++){
                int num = pq.poll();
                num += arr[i];
                if(num > X){
                    flag = 0;
                    break;
                }
                pq.add(num);
            }
            if(flag == 0){
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}