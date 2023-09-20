import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };
    static char[][] map;
    static int[][][] visited;
    static int[] c1 = new int[2];
    static int[] c2 = new int[2];
    static int y, x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cflag = 0;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new char[y][x];
        visited = new int[y][x][4];

        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < x; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 'C') {
                    if (cflag == 0) {
                        c1[0] = i;
                        c1[1] = j;
                        cflag = 1;
                    } else {
                        c2[0] = i;
                        c2[1] = j;
                    }
                }
            }
        }
        System.out.println(solve());
    }

    static int check(int y, int x){
        int min;

        min = visited[y][x][0];
        for(int i = 0; i < 4; i++){
            if(visited[y][x][i] < min)
                min = visited[y][x][i];
        }
        return min;
    }

    static int solve() {

        PriorityQueue<Pair> q = new PriorityQueue<>((e1, e2) -> {
            return e1.mirror - e2.mirror;
        });
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int curY = c1[0] + dy[i];
            int curX = c1[1] + dx[i];

            if (curY < 0 || curX < 0 || curY >= y || curX >= x || map[curY][curX] == '*')
                continue;

            q.add(new Pair(c1[0] + dy[i], c1[1] + dx[i], 0, i));
            visited[c1[0] + dy[i]][c1[1] + dx[i]][i] = 0;
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curY = cur.y;
            int curX = cur.x;
            int mirror = cur.mirror;
            int dir = cur.dir;

            if (curY == c2[0] && curX == c2[1]) {
                return (mirror);
            }

            for (int i = 0; i < 4; i++) {
                int newY = curY + dy[i];
                int newX = curX + dx[i];

                if (newY < 0 || newX < 0 || newY >= y || newX >= x || map[newY][newX] == '*'
                        || (newY == c1[0] && newX == c1[1]))
                    continue;

                if (i == dir) {
                    if (mirror > check(newY, newX) || mirror >= visited[newY][newX][i])
                        continue;
                    visited[newY][newX][i] = mirror;
                    q.add(new Pair(newY, newX, mirror, i));
                } else {
                    if (mirror + 1 > check(newY, newX) || mirror >= visited[newY][newX][i])
                        continue;
                    visited[newY][newX][i] = mirror + 1;
                    q.add(new Pair(newY, newX, mirror + 1, i));
                }
            }
        }

        return (0);
    }

    public static class Pair {
        public int x;
        public int y;
        public int mirror;
        public int dir;

        public Pair(int y, int x, int mirror, int dir) {
            this.y = y;
            this.x = x;
            this.mirror = mirror;
            this.dir = dir;
        }
    }
}