import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int H, W, x, y;
        
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[][] map = new int[H+y][W+x];
        int[][] originalMap = new int[H][W];

        for(int i = 0; i < H+y; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < x; j++){
                originalMap[i][j] = map[i][j];
            }
        }
        
        for(int i = 0; i < y; i++){
            for(int j = 0; j < W; j++){
                originalMap[i][j] = map[i][j];
            }
        }
        
        for(int i = y; i < H; i++){
            for(int j = x; j < W; j++){
                originalMap[i][j] = map[i][j] - originalMap[i-y][j-x];
            }
        }
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                bw.write(originalMap[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}