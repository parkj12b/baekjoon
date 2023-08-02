import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int ripenTomato = 0;
    static int daysTook = 0;
    static int emptyBlocks = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        Deque<Integer[]> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();                
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j <M; j++){
                if(map[i][j] == 1){
                    queue.addLast(new Integer[]{i,j});
                    ripenTomato++;
                } else if(map[i][j] == -1){
                    emptyBlocks++;
                }
            }
        }

        while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Integer[] spot = queue.pollFirst();

                int y = spot[0];
                int x = spot[1];

                for(int j  = 0; j < 4; j++){
                    int newY = y + dy[j];
                    int newX = x + dx[j];

                    if(newY < 0 || newX < 0 || newY >= N || newX >= M || map[newY][newX] == -1 || map[newY][newX] == 1){
                        continue;
                    }

                    if(map[newY][newX] == 0){
                        ripenTomato++;
                        map[newY][newX] = 1;
                        queue.addLast(new Integer[]{newY, newX});
                    }

                }
            }
            daysTook++;
        }
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < M; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        if(N*M != (ripenTomato + emptyBlocks)){
            System.out.println("-1");
        } else {
            System.out.println(daysTook-1);
        }

    }
    //make the colors r,b,and n for null
    
}