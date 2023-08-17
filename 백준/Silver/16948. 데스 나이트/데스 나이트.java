import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] dy = {-2,-2,0,0,2,2};
        int[] dx = {-1,1,-2,2,-1,1};

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());
        
        boolean[][] visit = new boolean[N][N];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startR, startC));
        visit[startR][startC] = true;
        int counter = 0;
        if(startR == endR && startC == endC){
            System.out.println(0);
        } else {
            esc: while(!queue.isEmpty()){
                for(int i = 0, length = queue.size(); i < length; i++){
                    Pair p = queue.poll();
                    int y = p.y;
                    int x = p.x;
                    for(int j = 0; j < 6; j++){
                        int newY = y + dy[j];
                        int newX = x + dx[j];
    
                        if(newY < 0 || newX < 0 || newY >= N || newX >= N || visit[newY][newX]) continue;
                        visit[newY][newX] = true;
                        if(newY == endR && newX == endC){
                            counter++;
                            break esc;
                        }
                        queue.add(new Pair(newY, newX));
                    }
                }
                counter++;
            }
            if(!visit[endR][endC]){
                System.out.println(-1);
            } else {
                System.out.println(counter);
            }
        }
    }

    static class Pair{
        int y,x;
        Pair(int y,int x){
            this.y = y;
            this.x = x;
        }
    }
}