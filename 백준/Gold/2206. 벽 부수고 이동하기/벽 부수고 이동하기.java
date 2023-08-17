import java.io.*;
import java.util.*;

public class Main {

    static int N, M; 
    static int[][] map;
    static int[][] visit;
    static int[][] visitWall;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int minPath = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M];
        visitWall = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(visit[i], -1);
        }
        
        int counter = 2;
        visit[N-1][M-1] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(N-1,M-1));
        while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Pair p = queue.poll();

                int y = p.y;
                int x = p.x;

                for(int j = 0; j < 4; j++){
                    int newY = y+dy[j];
                    int newX = x+dx[j];

                    if(newY < 0 || newX < 0 || newY >= N || newX >= M) continue;

                    if(visit[newY][newX] != -1 || map[newY][newX] == 1) continue;
                    
                    visit[newY][newX] = counter;
                    queue.add(new Pair(newY, newX));
                }
            }
            counter++;
        }
        if(visit[0][0] != -1 && visit[0][0] < minPath) minPath = visit[0][0];
        queue.add(new Pair(0,0));
        counter = 1;
        visitWall[0][0] = 1;
        while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Pair p = queue.poll();

                int y = p.y;
                int x = p.x;

                for(int j = 0; j < 4; j++){
                    int newY = y+dy[j];
                    int newX = x+dx[j];

                    if(newY < 0 || newX < 0 || newY >= N || newX >= M) continue;

                    if(visitWall[newY][newX] == 1) continue;
                    
                    if(map[y][x] == 1){
                        if(visit[newY][newX] != -1){
                            int pathLength = counter + visit[newY][newX];
                            if(pathLength < minPath) minPath = pathLength;
                        }
                    } else {
                        visitWall[newY][newX] = 1;
                        queue.add(new Pair(newY, newX));
                    }
                }
            }
            counter++;
        }
        if(minPath == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(minPath);
        }
    }

    static class Pair{
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}