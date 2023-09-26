import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        int node1 = 0;
        int node2 = 0;
        boolean[] visit = new boolean[n + 1];
        int[] parents = new int[n + 1];

        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            if(map.containsKey(node1)){
                map.get(node1).add(node2);
            } else {
                map.put(node1, new HashSet<>());
                map.get(node1).add(node2);
            }
            if(map.containsKey(node2)){
                map.get(node2).add(node1);
            } else {
                map.put(node2, new HashSet<>());
                map.get(node2).add(node1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()){
            int parent = q.poll();
            HashSet<Integer> children = map.get(parent);
            for(int child : children){
                if(visit[child])
                    continue;
                q.add(child);
                visit[child] = true;
                parents[child] = parent;
            }
        }
        for(int i = 2, length = parents.length; i < length; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
    }

}