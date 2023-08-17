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
        int[] arr = new int[N+1];
        Queue<Integer> orderQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num] = i;
            orderQueue.add(num);
        }
        for(int i = 1; i <= N; i++){
            Collections.sort(map.get(i), (a,b)->{
                return arr[a] - arr[b];
            });
        }
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        visit[1] = true;
        orderQueue.poll();

        esc: while(!stack.isEmpty()){
            int num = stack.peek();
            ArrayList<Integer> list = map.get(num);
            if(orderQueue.isEmpty()){
                break;
            }
            for(int i = 0; i < list.size(); i++){
                int nextNum = list.get(i);
                if(visit[nextNum]){
                    list.remove(i);
                    i--;
                }
                if(nextNum == orderQueue.peek()){
                    orderQueue.poll();
                    visit[nextNum] = true;
                    stack.push(nextNum);
                    continue esc;
                }
            }
            stack.pop();

        }
        
        if(orderQueue.isEmpty()){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}