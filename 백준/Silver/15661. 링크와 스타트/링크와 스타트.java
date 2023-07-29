import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Integer> member1, member2;
    static int[][] power;
    static int team1 = 0, team2 = 0;
    static int N;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(reader.readLine());
        member1 = new ArrayList<>();
        member2 = new ArrayList<>();
        power = new int[N][N];
        for(int i = 0; i < N; i++){
            member2.add(i);
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j++){
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0,0);
        System.out.println(min);
    }

    static void search(int depth, int index){
        

            for(int i = 0; i < member1.size(); i++){
                int num1 = member1.get(i);
                for(int j = i+1; j < member1.size(); j++){
                    int num2 = member1.get(j);
                    team1 += power[num1][num2];
                    team1 += power[num2][num1];
                }
            }
            for(int i = 0; i < member2.size(); i++){
                int num1 = member2.get(i);
                for(int j = i+1; j < member2.size(); j++){
                    int num2 = member2.get(j);
                    team2 += power[num1][num2];
                    team2 += power[num2][num1];
                }
            }
            int diff = Math.abs(team2 - team1);
            // System.out.println(team2 + " : " + team1);
            if(diff < min){
                min = diff;
            }
            team1 = 0;
            team2 = 0;
        if(depth == N/2){
            return;
        }
        for(int i = index; i < N; i++){
            member1.add(Integer.valueOf(i));
            member2.remove(Integer.valueOf(i));
            search(depth + 1, i + 1);
            member1.remove(Integer.valueOf(i));
            member2.add(Integer.valueOf(i));
        }
    }
}
