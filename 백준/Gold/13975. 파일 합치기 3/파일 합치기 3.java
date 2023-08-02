import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int ripenTomato = 0;
    static int daysTook = 0;
    static int emptyBlocks = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            queue.clear();
            Long counter = 0L;
            //스트림을 사용하기에 K 가 필요가 없음
            br.readLine();
            Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).forEach(queue::add);

            while (queue.size() > 1) {
                Long a = queue.poll();
                Long b = queue.poll();

                counter += a + b;

                queue.add(a + b);
            }
            bw.write(counter+"\n");
        }
        bw.flush();
    }
}