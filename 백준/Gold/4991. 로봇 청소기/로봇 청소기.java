import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static Pair[] order = new Pair[11];
    static int[][] distance = new int[11][11];
    static int y, x;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static HashMap<Pair, Integer> pairToInt;
    static int[] visitOrder = new int[11];
    static int numDust;
    static int minMoves;
    static boolean[] visitdfs = new boolean[11];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        esc: while(x != 0 && y != 0) {
            boolean solveable = true;
            numDust = 0;
            pairToInt = new HashMap<Pair, Integer>();
            map = new char[y][x];
            minMoves = Integer.MAX_VALUE;
            for(int i = 0; i < y; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < x; j++){
                    if(map[i][j] == '*'){
                        order[++numDust] = new Pair(i, j);
                        pairToInt.put(order[numDust], numDust);
                    } else if(map[i][j] == 'o'){
                        order[0] = new Pair(i, j);
                        pairToInt.put(order[0], 0);
                    }
                }
            }
            for(int i = 0; i <= numDust; i++){
                if(!bfs(order[i], i)){
                    solveable = false;
                    minMoves = -1;
                }
            }
            if(solveable){
                dfs(1);
            }
            System.out.println(minMoves);
            // for(int i = 0; i <= numDust; i++){
            //     for(int j = 0; j <= numDust; j++){
            //         System.out.print(distance[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
        }
    }

    public static boolean bfs(Pair p, int pairOrder){
        Queue<Pair> q = new LinkedList<Pair>();
        boolean[][] visit = new boolean[y][x];
        int counter = 0;
        int finishChecker = pairOrder;
        visit[p.y][p.x] = true;
        q.add(p);

        esc: while(!q.isEmpty()){
            counter++;
            for(int i = 0, length = q.size(); i < length; i++){
                Pair curP = q.poll();
                int curY = curP.y;
                int curX = curP.x;

                for(int j = 0; j < 4; j++){
                    int checkY = curY + dy[j];
                    int checkX = curX + dx[j];

                    if(checkY < 0 || checkX < 0 || checkY >= y || checkX >= x || visit[checkY][checkX] || map[checkY][checkX] == 'x'){
                        continue;
                    }

                    visit[checkY][checkX] = true;
                    if(map[checkY][checkX] == '*'){
                        int orderIndex = pairToInt.get(new Pair(checkY, checkX));
                        if(orderIndex > pairOrder){
                            finishChecker++;
                        }
                        distance[pairOrder][orderIndex] = counter;
                        distance[orderIndex][pairOrder] = counter;
                        if(finishChecker == numDust)
                            return true;
                    }
                    q.add(new Pair(checkY, checkX));
                }
            }
        }
        // System.out.println("finish CHecker: " + finishChecker);
        return false;
    }

    public static void dfs(int depth){
        if(depth > numDust){
            int moves = 0;
            for(int i = 1; i <= numDust; i++){
                int from = visitOrder[i - 1];
                int to = visitOrder[i];
                moves += distance[from][to];
            }
            if(moves < minMoves){
                minMoves = moves;
            }
            return ;
        }
        
        for(int i = 1; i <= numDust; i++){
            if(visitdfs[i])
                continue;
            visitOrder[depth] = i;
            visitdfs[i] = true;
            dfs(depth + 1);
            visitdfs[i] = false;
        }
    }

    public static class Pair{
        public int y;
        public int x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }

        @Override
        public int hashCode() {
            return (y + x) * (y * x);
        }

        @Override
        public boolean equals(Object o){
            Pair p = (Pair)o;

            if(p.y == y && p.x == x)
                return true;
            return false;
        }
    }
}