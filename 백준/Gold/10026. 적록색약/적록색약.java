import java.io.*;
import java.util.*;

public class Main {
    static char map[][];
    static boolean visited[][][];
    static int normalNum = 0;
    static int blindNum = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n][2];


        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j][0])
                {
                    visited[i][j][0] = true;
                    searchNormal(new Pair(i, j));
                    normalNum++;
                }
                if(!visited[i][j][1]){
                    visited[i][j][1] = true;
                    searchBlind(new Pair(i, j));        
                    blindNum++;
                }
            }
        }
        System.out.println(normalNum + " " + blindNum);
    }

    public static void searchNormal(Pair p){
        Stack<Pair> stack = new Stack<>();
        stack.add(p);
        char c = map[p.y][p.x];
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int y = pair.y;
            int x = pair.x;

            for(int i = 0; i < 4; i++){
                int checkY = y + dy[i];
                int checkX = x + dx[i];

                if(checkY < 0 || checkY >= n || checkX < 0 || checkX >= n || visited[checkY][checkX][0]){
                    continue;
                }

                if(c != map[checkY][checkX])
                    continue;

                visited[checkY][checkX][0] = true;
                stack.add(new Pair(checkY, checkX));

            }
        }
    }

    public static void searchBlind(Pair p){
        Stack<Pair> stack = new Stack<>();
        stack.add(p);
        char c = map[p.y][p.x];
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            int y = pair.y;
            int x = pair.x;

            for(int i = 0; i < 4; i++){
                int checkY = y + dy[i];
                int checkX = x + dx[i];

                if(checkY < 0 || checkY >= n || checkX < 0 || checkX >= n || visited[checkY][checkX][1]){
                    continue;
                }

                if(c == 'B' && c != map[checkY][checkX])
                    continue;

                if((c == 'G' || c == 'R') && map[checkY][checkX] == 'B')
                    continue;
                
                visited[checkY][checkX][1] = true;
                stack.add(new Pair(checkY, checkX));

            }
        }
    }

    public static class Pair{
        int y;
        int x;
        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}