import java.io.*;
import java.util.*;

public class Main {
    static int targetLength;
    static int target;
    static int[] brokenNum;
    static int min = Integer.MAX_VALUE;
    static int intMin = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String targetStr = reader.readLine();
        target = Integer.parseInt(targetStr);
        targetLength = targetStr.length();

        int N = Integer.parseInt(reader.readLine());
        
        brokenNum = new int[10];
        
        min = Math.abs(target - 100);
        if (N != 0) {
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                brokenNum[num] = 1;
            }
        }

        search(0, "");
        System.out.println(min);
        // System.out.println(intMin);

    }

    static void search(int depth, String num) {
        if(num.length() > 0){
            int intNum = Integer.parseInt(num);
            int diff = Math.abs(intNum - target);
            if (diff + num.length() < min) {
                min = diff + num.length();
                intMin = intNum;
            }
        }
        if (depth == targetLength+1) {
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (brokenNum[i] == 1)
                continue;
            
            if(Integer.parseInt(num+i) > 1000000){
                return;
            }
            search(depth + 1, num + i);
        }
    }

}
