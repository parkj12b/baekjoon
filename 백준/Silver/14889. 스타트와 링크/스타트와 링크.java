import java.io.*;
import java.util.*;


public class Main {
    
    // static boolean[][] visited;
    static boolean[] visit;
    static int N;
    static int[][] map;

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0,0);
        System.out.println(min);
        
    }

    static void recur(int index, int count){
        if(count == N/2){
            diff();
            return;
        }

        for(int i = index; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                recur(i+1, count+1);
                visit[i] = false;
            }
        }
    }

    static void diff(){
        int team1 = 0;
        int team2 = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                if(visit[i] == true && visit[j] == true){
                    team1 += map[i][j];
                    team1 += map[j][i];
                }
                else if(visit[i] == false && visit[j] == false){
                    team2 += map[i][j];
                    team2 += map[j][i];
                }
            }
        }
        int difference = Math.abs(team1-team2);
       
        if (difference == 0) {
			System.out.println(difference);
			System.exit(0);
		}
        min = Math.min(difference,min);
        
    }

    

}