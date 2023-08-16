import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<HashSet<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            map.add(new HashSet<>());
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
        }

        boolean isGood = true;
        orderQueue.poll();
        visit[1] = true;
        queue.add(1);

        while(!queue.isEmpty()){
            int num = queue.poll();

            HashSet<Integer> list = new HashSet<>(map.get(num));
            ArrayList<Integer> newList = new ArrayList<>(list);
            for(int j = 0; j < newList.size(); j++){
                int temp = newList.get(j);

                if(visit[temp]){
                    list.remove(Integer.valueOf(temp));
                }
            }
            for(int i = 0; i < list.size(); i++){
                int temp = orderQueue.poll();
                queue.add(temp);
                if(list.contains(temp)){
                    list.remove(Integer.valueOf(temp));
                    i--;
                }
                visit[temp] = true;
            }
            if(!list.isEmpty()){
                isGood = false;
                break;
            }
        }
        if(isGood){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}