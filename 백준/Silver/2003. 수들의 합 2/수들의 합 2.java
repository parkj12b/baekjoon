import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long sum = 0; 
        int counter = 0;
        arr = new long[N];
        int pointer1 = 0;
        int pointer2 = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(st.nextToken());
            if(sum == M){
                counter++;
            }
            arr[i] = sum;
        }
        sum = 0;

        while(pointer2 < N){
            sum = arr[pointer2] - arr[pointer1];
            if(sum < M){
                pointer2++;
            } else if(sum == M){
                counter++;
                pointer2++;
                pointer1++;
            } else {
                pointer1++;
            }
        }
        System.out.println(counter);
    }


}