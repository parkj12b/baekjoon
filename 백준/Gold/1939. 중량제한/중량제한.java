import java.io.*;
import java.util.*;

public class Main {
    static int min = 0, max = Integer.MAX_VALUE, start, end;
    static ArrayList<ArrayList<Node>> bridges;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bridges = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            bridges.add(new ArrayList<>());
        }
        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            bridges.get(A).add(new Node(B,C));
            bridges.get(B).add(new Node(A,C));
            if (C < min) {
                min = C;
            }
            if (C > max) {
                max = C;
            }
        }

        st = new StringTokenizer(reader.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while(min <= max){
            int mid = (min+max)/2;
            visited = new int[N+1];
            if(bfs(mid)){
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        System.out.println(max);
    }

    static boolean bfs(int cost){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = 1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp == end){
                return true;
            }
            for(Node node : bridges.get(temp)){
                if(node.weight >= cost && visited[node.index] == 0){
                    queue.add(node.index);
                    visited[node.index] = 1;
                }
            }
        }
        return false;
    }

    static class Node {
        int index, weight;
        Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }
    

}
