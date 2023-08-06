import java.io.*;
import java.util.*;

public class Main {

    static int N,S,M;
    static boolean playedAll = false;
    static int[] vChange;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> nextQueue = new ArrayDeque<>();
        queue.addLast(S);
        int counter = 0;
        boolean allTraversed = false;
        while(!queue.isEmpty()){
            if(counter == N){
                allTraversed = true;
                break;
            }
            for(int i = 0, length = queue.size(); i < length; i++){
                int num = queue.pollFirst();

                int checkNum = num + arr[counter];
                if(checkNum >= 0 && checkNum <= M){
                    if(!nextQueue.contains(checkNum)){
                        nextQueue.addLast(checkNum);
                    }
                    
                }                
                checkNum = num - arr[counter];
                if(checkNum >= 0 && checkNum <= M){
                    if(!nextQueue.contains(checkNum)){
                        nextQueue.addLast(checkNum);
                    }
                }                
            }
            counter++;
            queue.addAll(nextQueue);
            nextQueue.clear();
        }
        int max = 0;
        while(!queue.isEmpty()){
            int num = queue.pollFirst();
            if(num > max) max = num;
        }
        if(!allTraversed){
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
    }
}