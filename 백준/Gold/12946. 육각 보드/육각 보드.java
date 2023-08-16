import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int map[][];
    static boolean doColor[][];
    static boolean visit[][];
    static int[] dy = { -1, -1, 0, 0, 1, 1 };
    static int[] dx = { 0, 1, -1, 1, -1, 0 };
    static int maxColor = 0;
    static boolean finished = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        doColor = new boolean[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'X') {
                    doColor[i][j] = true;
                }
            }
        }
        esc: for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(finished){
                    break esc;
                }
                if(visit[i][j] || !doColor[i][j]) continue;
                if(maxColor < 1) maxColor = 1;
                search(i,j, 1);
            }
        }
        
        System.out.println(maxColor);
    }

    static void search(int y, int x, int color) {
        map[y][x] = color;
        if(finished){
            return;
        }
        for(int i = 0; i < 6; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            
            if(newY < 0 || newY >= N || newX < 0 || newX >= N || !doColor[newY][newX]) continue;
            if(map[newY][newX] == color){
                maxColor = 3;
                finished = true;
                return;
            }
            
            if(maxColor < 2) maxColor = 2;
            if(!visit[newY][newX]){
                visit[newY][newX] = true;
                search(newY, newX, color*-1);
            }
        }
    }
}