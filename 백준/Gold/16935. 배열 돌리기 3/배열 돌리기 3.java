import java.io.*;
import java.util.*;

public class Main {
    static Integer[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        }
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int type = Integer.parseInt(st.nextToken());
            flip(type);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void flip(int type) {
        if (type == 1) {
            Integer[] temp1;
            for (int i = 0; i < N/2; i++){
                temp1 = map[N-i-1].clone();
                map[N-i-1] = map[i].clone();
                map[i] = temp1;
            }
        } else if (type == 2) {
            for(int i = 0; i < N; i++){
                Collections.reverse(Arrays.asList(map[i]));
            }
        } else if (type == 3) {
            
            Integer[][] copyMap = new Integer[N][M];
            for(int i = 0; i < N; i++){
                copyMap[i] = map[i].clone();
            }
            map = new Integer[M][N];
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = copyMap[N-j-1][i];
                }
            }
        } else if (type == 4) {
            Integer[][] copyMap = new Integer[N][M];
            for(int i = 0; i < N; i++){
                copyMap[i] = map[i].clone();
            }
            map = new Integer[M][N];
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = copyMap[j][M-i-1];
                }
            }
        } else if (type == 5) {
            int temp1 = 0;
            int temp2 = map[0][0];


            for(int i = 0; i < N/2; i++){
                for(int j = 0; j < M/2; j++){
                        temp2 = map[i][j];
                    for(int k = 0; k < 4; k++){
                        if(k == 0){
                            temp1 = map[i][M/2+j];
                            map[i][M/2+j] = temp2;
                            temp2 = temp1;
                        } else if(k == 1){
                            temp1 = map[N/2+i][M/2+j];
                            map[N/2+i][M/2+j] = temp2;
                            temp2 = temp1;
                            
                        } else if(k == 2){
                            temp1 = map[N/2+i][j];
                            map[N/2+i][j] = temp2;
                            temp2 = temp1;
                            
                        } else {
                            temp1 = map[i][j];
                            map[i][j] = temp2;
                            temp2 = temp1;

                        }
                    }
                }
            }
        } else {
            int temp1 = 0;
            int temp2 = map[0][0];


            for(int i = 0; i < N/2; i++){
                for(int j = 0; j < M/2; j++){
                    temp2 = map[i][j];
                    for(int k = 0; k < 4; k++){
                        if(k == 0){
                            temp1 = map[N/2+i][j];
                            map[N/2+i][j] = temp2;
                            temp2 = temp1;
                        } else if(k == 1){
                            temp1 = map[N/2+i][M/2+j];
                            map[N/2+i][M/2+j] = temp2;
                            temp2 = temp1;
                            
                        } else if(k == 2){
                            temp1 = map[i][M/2+j];
                            map[i][M/2+j] = temp2;
                            temp2 = temp1;
                            
                        } else {
                            temp1 = map[i][j];
                            map[i][j] = temp2;
                            temp2 = temp1;

                        }
                    }
                }
            }

        }
        N = map.length;
        M = map[0].length;
    }}