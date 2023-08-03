import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visit = new int[100002];
        Arrays.fill(visit, Integer.MAX_VALUE);
        Deque<Pair> queue = new ArrayDeque<Pair>();

        queue.addLast(new Pair(N,0));
        visit[N] = 0;
        while(!queue.isEmpty()){
            Pair p = queue.pollFirst();
            int cur = p.cur;
            int time = p.time;

            for(int i = 0; i < 3; i++){
                int nextCur = cur;
                int nextTime = time;
                if(i == 0){
                    nextCur -= 1;
                    nextTime += 1;
                } else if(i == 1){
                    nextCur += 1;
                    nextTime += 1;
                } else if(i == 2){
                    nextCur *= 2;
                } 

                if(nextCur < 0 || nextCur > 100000 || visit[nextCur] <= nextTime){
                    continue;
                }
                visit[nextCur] = nextTime;
                queue.add(new Pair(nextCur, nextTime));
            }
        }
        System.out.println(visit[K]);
    }

    static class Pair{
        int cur, time;

        Pair(int cur,int time) {
            this.cur = cur;
            this.time = time;
        }
    }

}