import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1, 0};
    static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        ArrayList<char[]> map = new ArrayList<>();
        int[][] visit = new int[9][8];
        map.add(new char[]{'.','.','.','.','.','.','.','.'});
        for(int i = 0; i < 8; i++){
            char[] cArr = br.readLine().toCharArray();
            map.add(cArr);
        }
        boolean found = false;
        Queue<Pair> queue = new LinkedList<>();
        int depth = 1;
        queue.add(new Pair(8, 0));
        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Pair p = queue.poll();
                int y = p.y;
                int x = p.x;
                if(map.get(y)[x] == '#') continue;

                for(int j = 0; j < 9; j++){
                    int newY = y + dy[j];
                    int newX = x + dx[j];

                    if(newY <= 0 || newY >= 9 || newX < 0 || newX >= 8) continue;

                    if(map.get(newY)[newX] == '#' || map.get(newY-1)[newX] == '#') continue;

                    if(visit[newY][newX] == depth) continue;

                    if(newY == 1 && newX == 7){
                        found = true;
                        break esc;
                    }
                    visit[newY][newX] = depth;
                    queue.add(new Pair(newY, newX));
                }
            }
            depth++;
            map.add(0, new char[]{'.','.','.','.','.','.','.','.'});
            map.remove(9);
        }
        if(found){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}