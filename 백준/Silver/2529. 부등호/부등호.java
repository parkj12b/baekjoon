import java.io.*;
import java.util.*;

public class Main {
    static int[] visit, arrNum;
    static char[] cArr;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static int K;
    static StringBuilder sb = new StringBuilder();
    static String maxStr = "", minStr = "";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        visit = new int[10];
        arrNum = new int[10];
        K = Integer.parseInt(reader.readLine());
        cArr = new char[K];
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < K; i++){
            cArr[i] = st.nextToken().charAt(0);
        }
        for(int i = 0; i < 10; i++){
            arrNum[0] = i;
            sb.append(i);
            visit[i] = 1;
            search(1);
            sb.deleteCharAt(sb.length()-1);
            arrNum[0] = 0;
            visit[i] = 0;
        }
        System.out.println(maxStr);
        System.out.println(minStr);

        
    }

    static void search(int depth){
         if(depth == K+1){
            long num = Long.parseLong(sb.toString());
            if(num > max){
                max = num;
                maxStr = sb.toString();
            }
            if(num < min){
                min = num;
                minStr = sb.toString();
            }
            return;
        }
        int num = arrNum[depth-1];
        int c = cArr[depth-1];
        for(int i = c == '>' ? 0 : num+1; i < 10; i++){
            if(visit[i] == 1) continue;
            if(c == '>'){
                if(i >= num) continue;
            } else {
                if(i <= num) continue;
            }
            visit[i] = 1;
            arrNum[depth] = i;
            sb.append(i);
            search(depth+1);
            visit[i] = 0;
            sb.deleteCharAt(sb.length()-1);
            arrNum[0] = 0;
        }

    }
}
