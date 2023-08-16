import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[N + 1];

        
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map.get(a).add(b);
            map.get(b).add(a);
            
        }
        Queue<Integer> orderQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            orderQueue.add(num);
            arr[num] = i;
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(map.get(i), (a,b)->{
                return arr[a] - arr[b];
            });
        }
        
        // for(int i = 1; i <=N; i++){
        //     for(int num : map.get(i)){
        //         System.out.print(num + " ");
        //     }
        //     System.out.println();
        // }

        queue.add(1);
        visit[1] = true;
        // orderQueue.poll();
        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                int num = queue.poll();

                if(num == orderQueue.peek()){
                    orderQueue.poll();
                    ArrayList<Integer> list = map.get(num);

                    for(int nextNum : list){
                        if(visit[nextNum]) continue;
                        visit[nextNum] = true;
                        queue.add(nextNum);
                    }
                    if(orderQueue.isEmpty()){
                        break esc;
                    }
                }
            }
        }
        if(orderQueue.isEmpty()){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}