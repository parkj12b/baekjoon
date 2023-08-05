import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 0; i < R; i++){
            spin();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void spin(){
        int direction = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        int[][] tempMap = new int[map.length][map[0].length];

        for(int i = 0; i < map.length; i++){
            tempMap[i] = map[i].clone();
        }

        for(int i = 0; i < Math.min(N,M)/2; i++){
            queue.addLast(new Pair(i,i));
            direction = 0;
            while(true){
                Pair spot = queue.pollFirst();
                int curY = spot.y;
                int curX = spot.x;

                
                int nextY = curY + dy[direction];
                int nextX = curX + dx[direction];
                
                if(nextY < 0+i || nextY >= N-i || nextX < 0+i || nextX >= M-i){
                    direction++;
                    queue.add(new Pair(curY, curX));
                    continue;
                }
                
                tempMap[nextY][nextX] = map[curY][curX];
                if(nextY == i && nextX == i){
                    break;
                }
                queue.add(new Pair(nextY, nextX));
            }
        }
        map = tempMap;
    }

    static class Pair{
        int y,x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}