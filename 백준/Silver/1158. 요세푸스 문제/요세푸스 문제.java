import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dp, map;
    static int[] dy, dx;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        writer.write("<");
        while(!queue.isEmpty()){
            if(queue.size() == 1){
                writer.write(queue.poll()+">");
                break;
            }
            for(int i = 0; i < K-1; i++){
                queue.add(queue.poll());
            }
            writer.write(queue.poll()+", ");
        }
        writer.flush();
    }

}
