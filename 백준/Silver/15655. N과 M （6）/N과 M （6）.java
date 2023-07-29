import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, toPrint, visit;
    static int N, M;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        toPrint = new int[M];
        visit = new int[N];
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        search(0, -1);
        writer.flush();


    }

    static void search(int depth, int index) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                writer.write(toPrint[i]+" ");
            }
            writer.write("\n");
            return;
        }
        for(int i = index+1; i < N; i++){
            toPrint[depth] = arr[i];
            search(depth+1, i);
        }
    }

}
