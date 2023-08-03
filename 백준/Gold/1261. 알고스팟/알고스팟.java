import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int minCounter = Integer.MAX_VALUE;

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] visit = new int[N][M];
        
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        Deque<Pair> queue = new ArrayDeque<>();

        queue.addLast(new Pair(0,0,0));

        while(!queue.isEmpty()){
            Pair p = queue.pollFirst();
            int y = p.y;
            int x = p.x;
            int wall = p.wall;
            for(int i = 0; i < 4; i++){
                int newY = y + dy[i];
                int newX = x + dx[i];
                int newWall = wall;
                
                if(newY < 0 || newX < 0 || newY >= N || newX >= M){
                    continue;
                }
                if(map[newY][newX] == 1){
                    newWall++;
                }
                
                if(newWall >= visit[newY][newX]){
                    continue;
                }

                visit[newY][newX] = newWall;
                queue.add(new Pair(newY, newX, newWall));
            }
        
        }
        if(N == 1 && M ==1){
            System.out.println("0");
        } else {
            System.out.println(visit[N-1][M-1]);
        }
    }

    static class Pair{
        int y, x, wall;
        Pair(int y, int x, int wall){
            this.y = y;
            this.x = x;
            this.wall = wall;
        }
    }

}