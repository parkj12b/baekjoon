import java.io.*;
import java.util.*;

public class Main {
    static int curMin = 1;
    static int sum = 0;
    static int N;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        search(0,0);
        boolean numFound = false;
        int i = 1;
        while(!numFound){
            if(!set.contains(i)){
                numFound = true;
                curMin = i;
            }
            i++;
        }
        System.out.println(curMin);
    }

    static void search(int depth, int index){
        set.add(sum);
        for(int i = index; i < N; i++){
            sum += arr[i];
            search(depth+1, i+1);
            sum -= arr[i];
        }
        
    }

}