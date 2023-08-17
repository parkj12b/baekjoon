import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[101];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a,b);
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a,b);
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visit[1] = true;
        int counter = 0;
        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                int num = queue.poll();
                for(int j = 1; j <= 6; j++){
                    int nextNum = num + j;
                    if(map.containsKey(nextNum)){
                        nextNum = map.get(nextNum);
                    }
                    if(nextNum == 100){
                        counter++;
                        break esc;
                    }
                    if(visit[nextNum]) continue;
                    visit[nextNum] = true;
                    queue.add(nextNum);
                }
            }
            counter++;
        }
        System.out.println(counter);
    }
}