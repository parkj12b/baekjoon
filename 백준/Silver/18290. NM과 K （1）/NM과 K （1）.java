import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, max;
    static int[][] visit, map;
    static int sum = 0;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visit = new int[N][M];
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = -500000;
        search(0,0,0);
        System.out.println(max);
    }

    static void search(int y, int x,int depth) throws IOException{
        if(depth == K){
            if(sum > max){
                max = sum;
            }
            return;
        }
        for(int i = y; i < N; i++){
            for(int j = 0; j < M; j++){
                boolean isValid = true;
                if(visit[i][j] == 0){
                    for(int k = 0; k < 4; k++){
                        int newY = i + dy[k];
                        int newX = j + dx[k];
                        if(newY < 0 || newY >= N || newX < 0 || newX >= M){
                            continue;
                        }
                        if(visit[newY][newX] == 1){
                            isValid = false;
                            break;
                        }
                    }
                    if(isValid){
                        sum += map[i][j];
                        visit[i][j] = 1;
                        search(i,j, depth+1);
                        sum -= map[i][j];
                        visit[i][j] = 0;
                    }
                }
            }
        }
    }

}
