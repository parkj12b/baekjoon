import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] answer;
    static boolean[][] visit;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[N][M];
        visit = new boolean[N][M];

        Queue<Pair> queue = new LinkedList<Pair>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 0) {
                    queue.add(new Pair(i, j));
                } else {
                    answer[i][j] += 1;
                }
            }
        }

        Queue<Pair> nearWall = new LinkedList<Pair>();
        Queue<Pair> nearSpace = new LinkedList<Pair>();
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.y;
            int x = p.x;

            if(visit[y][x]){
                continue;
            }

            nearSpace.add(p);
            visit[y][x] = true;
            int counter = 1;
            while(!nearSpace.isEmpty()){
                Pair localP = nearSpace.poll();
                int subY = localP.y;
                int subX = localP.x;

                for(int i = 0; i < 4; i++){
                    int newY = subY + dy[i];
                    int newX = subX + dx[i];

                    if(newY < 0 || newY >= N || newX < 0 || newX >= M) continue;

                    if(visit[newY][newX]) continue;

                    if(map[newY][newX] == 1){
                        nearWall.add(new Pair(newY, newX));
                        visit[newY][newX] = true;
                        continue;
                    }

                    // since we already check for 1, there's no need to check again for 0
                    if(!visit[newY][newX]){
                        nearSpace.add(new Pair(newY, newX));
                        visit[newY][newX] = true;
                        counter++;
                    }
                }
            }
            while(!nearWall.isEmpty()){
                Pair wallPair = nearWall.poll();

                int wallY = wallPair.y;
                int wallX = wallPair.x;
                answer[wallY][wallX] += counter;
                visit[wallY][wallX] = false;
            }

        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(answer[i][j]%10+"");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}