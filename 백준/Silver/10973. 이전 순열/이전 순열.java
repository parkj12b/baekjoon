import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        for(int i = 0; i < N; i++){
            int num = arr[N-1-i];
            if(set.lower(num) != null){
                int lower = set.lower(num);
                arr[N-1-i] = lower;
                set.remove(lower);
                start = N-i;
                set.add(num);
                break;
            }
            set.add(num);
        }
        if(set.size() == N){
            bw.write("-1");
        } else {
            for(int i = start; i < N;i++){
                arr[i] = set.pollLast();
            }
            for(int i = 0; i < N; i++){
                bw.write(arr[i]+" ");
            }
        }
        bw.flush();
    }
}
