import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] arr;
    static boolean finished = false;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        arr = new int[N];
        map = new char[N][N];
        for(int i = 0, counter = 0; i < N; i++){
            for(int j = i; j < N; j++, counter++){
                map[i][j] = s.charAt(counter);
            }
        }
        // for(int i = 0; i < N; i++){
        //     for(int j = i; j < N; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        search(0);
        bw.flush();
    }

    static void search(int depth) throws IOException{
        if(finished){
            return;
        }
        if(depth == N){
            for(int i=0; i<N; i++){
                bw.write(arr[i]+" ");
            }
            finished = true;
            return;
        }
        if(map[depth][depth] == '-'){
            for(int i = -10; i < 0; i++){
                if(valid(i, depth)){
                    arr[depth] = i;
                    search(depth+1);
                }
            }
        } else if(map[depth][depth] == '+'){
            for(int i = 1; i < 11; i++){
                if(valid(i, depth)){
                    arr[depth] = i;
                    search(depth+1);
                }
            }
        } else {
            arr[depth] = 0;
            search(depth+1);
        }
    }

    static boolean valid(int num, int depth){
        for(int i = 0; i < depth; i++){
            int counter = num;
            for(int j = i; j < depth; j++){
                counter += arr[j];
            }
            
            if((map[i][depth] == '-' && counter >= 0) || (map[i][depth] == '+' && counter <= 0) ||  (map[i][depth] == '0' && counter != 0)){
                return false;
            }
        }
        return true;
    }
}
