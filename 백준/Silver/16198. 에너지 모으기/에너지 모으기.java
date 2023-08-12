import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static int sum = 0;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        search();
        System.out.println(maxSum);
    }

    static void search(){
        if(N == 2){
            if(sum > maxSum){
                maxSum = sum;
            }
            return;
        }
        for(int i = 1; i < list.size()-1; i++){
            int num = list.get(i);
            int subSum = list.get(i-1) * list.get(i+1);
            sum += subSum;
            list.remove(i);
            N-=1;
            search();
            N+=1;
            list.add(i, num);
            sum -= subSum;
        }
    }
}