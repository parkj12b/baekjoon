import java.io.*;
import java.util.*;

class Bridge {
    int destination;
    int weight;

    public Bridge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class Main {
    static int min = 0, max = Integer.MAX_VALUE, start, end;
    static int[] visited;
    static ArrayList<ArrayList<Bridge>> bridges;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        bridges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            bridges.add(new ArrayList<Bridge>());
        }

        for (int i = 0; i < M; i++) {
            input = reader.readLine().split("\\s+");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            bridges.get(A).add(new Bridge(B, C));
            bridges.get(B).add(new Bridge(A, C));
            min = Math.min(min, C);
            max = Math.max(max, C);
        }

        input = reader.readLine().split("\\s+");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        while (min <= max) {
            int mid = (min + max) / 2;
            visited = new int[N + 1];
            if (bfs(mid)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }

    static boolean bfs(int cost) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            if (temp == end)
                return true;
            for (Bridge bridge : bridges.get(temp)) {
                if (bridge.weight >= cost && visited[bridge.destination] == 0) {
                    visited[bridge.destination] = 1;
                    q.add(bridge.destination);
                }
            }
        }
        return false;
    }
}
