import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static char[][] map;
    static int[][][] numDoor;
    static int y, x;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            int p1y = 0, p1x = 0, p2y = 0, p2x = 0;
            int minDoor = Integer.MAX_VALUE;
            int flag = 0;
            boolean[][][] visit = new boolean[y+2][x+2][4];

            map = new char[y + 2][x + 2];
            numDoor = new int[y + 2][x + 2][4];
            for (int i = 1; i <= y; i++) {
                String s = br.readLine();
                for (int j = 1; j <= x; j++) {
                    map[i][j] = s.charAt(j - 1);
                    if (map[i][j] == '$') {
                        if (flag == 0) {
                            p1y = i;
                            p1x = j;
                            flag = 1;
                        } else {
                            p2y = i;
                            p2x = j;
                        }
                    }
                }
            }
            bfs(p1y, p1x, 0, visit);
            bfs(p2y, p2x, 1, visit);
            bfs(0, 0, 2, visit);
            for(int i = 0; i <= y + 1; i++){
                for(int j = 0; j <= x + 1; j++){
                    numDoor[i][j][3] += numDoor[i][j][2] + numDoor[i][j][1] + numDoor[i][j][0];
                    visit[i][j][3] = visit[i][j][2] && visit[i][j][1] && visit[i][j][0];
                    if(map[i][j] == '#'){
                        numDoor[i][j][3] -= 2;
                    } 
                    if(visit[i][j][3] && map[i][j] != '*' && numDoor[i][j][3] < minDoor){
                        minDoor = numDoor[i][j][3];
                    }
                }
            }
            
            bw.write(minDoor + "\n");
        }
        bw.flush();
    }

    public static void bfs(int startY, int startX, int type, boolean[][][] visit){
        Deque<Node> q = new ArrayDeque<>();

        q.add(new Node(startY, startX));
        while(!q.isEmpty()){
            Node node = q.pollFirst();
            int curY = node.y;
            int curX  = node.x;

            for(int i = 0; i < 4; i++){
                int checkY = curY + dy[i];
                int checkX = curX + dx[i];

                if(checkY < 0 || checkX < 0 || checkY > y + 1|| checkX > x + 1 || visit[checkY][checkX][type] || map[checkY][checkX] == '*'){
                    continue;
                }

                visit[checkY][checkX][type] = true;
                if(map[checkY][checkX] == '#'){
                    numDoor[checkY][checkX][type] = numDoor[curY][curX][type] + 1;
                    q.addLast(new Node(checkY, checkX));
                } else {
                    numDoor[checkY][checkX][type] = numDoor[curY][curX][type];
                    q.addFirst(new Node(checkY, checkX));
                }
            }
        }
    }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}