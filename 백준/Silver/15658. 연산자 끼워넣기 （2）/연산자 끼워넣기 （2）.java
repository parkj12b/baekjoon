import java.io.*;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arithematic = new int[4]; 
    static int[] numArr;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            arithematic[i] = Integer.parseInt(st.nextToken());
        }
        search(1, numArr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void search(int depth, int sum){
        if(depth == N){
            if(sum > max) max = sum;
            if(sum < min) min = sum;
            return;
        }
        
            if(arithematic[0] > 0){
                arithematic[0]--;
                search(depth+1,sum + numArr[depth]);
                arithematic[0]++;
            }
            if (arithematic[1] > 0){
                arithematic[1]--;
                search(depth+1,sum - numArr[depth]);
                arithematic[1]++;
                
            }
            if (arithematic[2] > 0){
                arithematic[2]--;
                search(depth+1,sum * numArr[depth]);
                arithematic[2]++;
                
            }
            if (arithematic[3] > 0){
                arithematic[3]--;
                search(depth+1,sum / numArr[depth]);
                arithematic[3]++;
                
            } 
    }

}