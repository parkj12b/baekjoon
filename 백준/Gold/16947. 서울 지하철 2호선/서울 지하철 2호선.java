import java.io.*;
import java.util.*;

public class Main {
    static boolean found = false;
    static boolean cycleFinished = false;
    static int intersection;
    static boolean[] visit;
    static int[] distance;
    static int INF = (int) 2e9;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        distance = new int[N+1];
        
        Arrays.fill(distance, INF);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)){
                map.get(a).add(b);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(b);
                map.put(a, l);
            }
            if(map.containsKey(b)){
                map.get(b).add(a);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(a);
                map.put(b, l);
            }
        }

        for(int i = 1; i < N; i++){
            if(visit[i] || found) continue;
            visit[i] = true;
            cycle(0,1);
        }
        Arrays.fill(visit, false);
        visit[intersection] = true;
        search(0, intersection);

        for(int i = 1; i <= N; i++){
            bw.write(distance[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    static void cycle(int lastNode, int curNode){

        
        ArrayList<Integer> list = map.get(curNode);

        for(int i = 0; i < list.size(); i++){
            int nextNode = list.get(i);
            if(nextNode == lastNode) continue;
            if(visit[nextNode]){
                found = true;   
                intersection = nextNode;
                distance[nextNode] = 0;
                distance[curNode] = 0;
                return;
            }
            visit[nextNode] = true;
            cycle(curNode, nextNode);
            if(cycleFinished){
                return;
            }
            if(curNode == intersection){
                cycleFinished = true;
                distance[curNode] = 0;
                return;
            }
            if(found){
                distance[curNode] = 0;
                return;
            }
        }
    }

    static void search(int depth, int curNode){
        distance[curNode] = depth;
        ArrayList<Integer> list = map.get(curNode);

        for(int i = 0; i < list.size(); i++){
            int nextNode = list.get(i);
            if(visit[nextNode]) continue;
            visit[nextNode] = true;
            if(distance[nextNode] != 0){
                search(depth +1, nextNode);
            } else {
                search(0, nextNode);
            }
        }


    }
}