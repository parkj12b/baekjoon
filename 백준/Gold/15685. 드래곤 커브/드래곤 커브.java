import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] map;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new boolean[101][101];
        //x, y, d, g
        //d is direciton, g is generation
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> nextQueue = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            queue.clear();
            nextQueue.clear();
            queue.addFirst(d);
            int generationCount = 0;
            
            map[y][x] = true;
            while(!queue.isEmpty()){
                for(int j = 0, length = queue.size(); j < length; j++){
                    int direction = queue.pollFirst();
                    y = y + dy[direction];
                    x = x + dx[direction];
                    
                    map[y][x] = true;
                    
                    direction += 1;
                    direction %= 4;
                    
                    nextQueue.addFirst(direction);
                }
                generationCount++;
                if(generationCount > g) break;
                
                queue.addAll(nextQueue);
            }
            
        }
        int[] checkY = {0, 0, 1, 1};
        int[] checkX = {0, 1, 0, 1};
        int answer = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i+checkY[0]][j+checkX[0]] && map[i+checkY[1]][j+checkX[1]] && map[i+checkY[2]][j+checkX[2]] && map[i+checkY[3]][j+checkX[3]]){
                    answer++;
                }
            }
        }
        // for(int i = 0; i < 101; i++){
        //     for(int j = 0; j < 101; j++){
        //         System.out.print(map[i][j] ? "1 " : "0 ");
        //     }
        //     System.out.println();
        // }
        System.out.println(answer);
    }
    
}