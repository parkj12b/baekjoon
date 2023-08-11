import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static int[][] coin = new int[2][2];
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static int coinDrop = 0;
    static int minPress = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int coinCount = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    if (coinCount == 0) {
                        coin[0][0] = i;
                        coin[0][1] = j;
                    } else {
                        coin[1][0] = i;
                        coin[1][1] = j;
                    }
                    coinCount++;
                }
            }
        }

        search(0);
        if (minPress == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minPress);
        }
    }

    static void search(int depth) {
        if (depth == 10) {
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            coinDrop = 0;
            int newY1 = coin[0][0] + dy[i];
            int newX1 = coin[0][1] + dx[i];
            int newY2 = coin[1][0] + dy[i];
            int newX2 = coin[1][1] + dx[i];
            
            if(newY1 < 0 || newY1 >= N || newX1 < 0 || newX1 >= M){
                coinDrop++;
            }
            if(newY2 < 0 || newY2 >= N || newX2 < 0 || newX2 >= M){
                coinDrop++;
            }
            if(coinDrop == 1){
                if(depth+1 < minPress){
                    minPress = depth+1;
                }
                continue;
            } else if(coinDrop == 2 || (newY1 == newY2 && newX1 == newX2)){
                continue;
            }
            boolean blocked1 = false;
            boolean blocked2 = false;
            if(map[newY1][newX1] == '#'){
                newY1 -= dy[i];
                newX1 -= dx[i];
                blocked1 = true;
            }
            if(map[newY2][newX2] == '#'){
                newY2 -= dy[i];
                newX2 -= dx[i];
                blocked2 = true;
            }

            if(!blocked1){
                coin[0][0] += dy[i];
                coin[0][1] += dx[i];
            }
            if(!blocked2){
                coin[1][0] += dy[i];
                coin[1][1] += dx[i];
            }
            
            search(depth+1);
            if(!blocked1){
                coin[0][0] -= dy[i];
                coin[0][1] -= dx[i];
            }
            if(!blocked2){
                coin[1][0] -= dy[i];
                coin[1][1] -= dx[i];
            }
            
        }

    }
}