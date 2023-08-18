import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visit = new boolean[N][M][K+1];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int depth = 2;
        boolean reachedEnd = false;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,K));
        
        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Pair p = queue.poll();
                int y = p.y;
                int x = p.x;
                int wall = p.wall;
                
                for(int j = 0; j < 4; j++){
                    int newY = y+ dy[j];
                    int newX = x+ dx[j];
                    int newWall = wall;
                    if(newY < 0 || newX < 0 || newY >= N || newX >= M) continue;
                    if(newY == N-1 && newX == M-1){
                        reachedEnd = true;
                        break esc;
                    }
                    if(map[newY][newX] == 1){
                        newWall--;
                        if(newWall < 0) continue;
                    }
                    if(visit[newY][newX][newWall]) continue;
                    visit[newY][newX][newWall] = true;
                    queue.add(new Pair(newY, newX, newWall));
                }
            }
            depth++;
        }
        if(N == 1 && M== 1){
            System.out.println(1);
        } else if(reachedEnd){
            System.out.println(depth);
        } else {
            System.out.println(-1);
        }
    }

    static class Pair {
        int y, x, wall;

        Pair(int y, int x, int wall) {
            this.y = y;
            this.x = x;
            this.wall = wall;
        }
    }
}