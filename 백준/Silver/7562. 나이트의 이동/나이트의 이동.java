import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

        Deque<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < T; i++){
            queue.clear();
            int minMoves = 0;
            
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boolean[][] visit = new boolean[N][N];

            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            
            queue.add(new Node(startY, startX));

            st = new StringTokenizer(br.readLine());

            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            esc: while(!queue.isEmpty()){
                for(int j = 0, length = queue.size(); j < length; j++){
                    Node node = queue.poll();
                    int y = node.y;
                    int x = node.x;
                    if(y == endY && x == endX){
                        break esc;
                    }

                    for(int k = 0; k < 8; k++){
                        int newY = y + dy[k];
                        int newX = x + dx[k];
                        
                        if(newY < 0 || newX < 0 || newY >= N || newX >= N || visit[newY][newX] == true){
                            continue;
                        }
                        visit[newY][newX] = true;
                        queue.add(new Node(newY, newX));
                    }
                }
                minMoves++;
                
            }
            bw.write(minMoves+"\n");

        }
        bw.flush();
        
    }

    static class Node{
        int x, y;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}