import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        int[][] tempMap = new int[map.length][map[0].length];
        for(int i = 0; i < Math.min(N,M)/2; i++){
            LinkedList<Integer> l = new LinkedList<>();
            for(int a= i; a < N-i; a++){
                l.add(map[a][i]);
            }
            for(int b=i+1; b < M-i; b++){
                l.add(map[N-i-1][b]);
            }
            for(int c=N-i-2; c >= i; c--){
                l.add(map[c][M-i-1]);
            }
            for(int d = M-i-2; d > i; d--){
                l.add(map[i][d]);
            }
            // for(int j = 0; j <l.size(); j++){
            //     System.out.print(l.get(j)+" ");
            // }
            int size = l.size();
            int index = (size - R % size) % size;
            for(int a= i; a < N-i; a++){
                tempMap[a][i] = l.get(index);
                index++;
                index %= size;
            }
            for(int b=i+1; b < M-i; b++){
                tempMap[N-i-1][b] = l.get(index);
                index++;
                index %= size;
            }
            for(int c=N-i-2; c >= i; c--){
                tempMap[c][M-i-1] = l.get(index);
                index++;
                index %= size;
            }
            for(int d = M-i-2; d > i; d--){
                tempMap[i][d] = l.get(index);
                index++;
                index %= size;
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(tempMap[i][j]+" ");
            }
            bw.write("\n");
        }        
        bw.flush();
        
    }

    
}