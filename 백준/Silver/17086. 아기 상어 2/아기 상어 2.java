import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int y;
        int x;
        Queue<Pair> q = new LinkedList<Pair>();
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];
        int[][] visit = new int[y][x];

        for(int i = 0; i < y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == '1'){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int max = 0;
        while(!q.isEmpty()){
            for(int i = 0, length = q.size(); i < length; i++){
                Pair p = q.poll();
                int curY = p.y;
                int curX = p.x;

                for(int j = 0; j < 8; j++){
                    int checkY = curY + dy[j];
                    int checkX = curX + dx[j];

                    if(checkY < 0 || checkX < 0 || checkY >= y || checkX >= x || visit[checkY][checkX] != 0 || map[checkY][checkX] == '1'){
                        continue;
                    }

                    visit[checkY][checkX] = p.distance + 1;
                    if(visit[checkY][checkX] > max){
                        max = visit[checkY][checkX];
                    }
                    q.add(new Pair(checkY, checkX, p.distance + 1));
                }
            }
        }
        System.out.println(max);
    }

    public static class Pair{
        int y;
        int x;
        int distance;
        public Pair(int y, int x, int distance){
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}