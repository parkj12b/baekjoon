import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> baseSet = new HashSet<Integer>();
        int M = Integer.parseInt(br.readLine());
        for(int i = 1; i < 21; i++){
            baseSet.add(i);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();

            if (operation.equals("all") || operation.equals("empty")) {
                if ("all".equals(operation)) {
                    set = (HashSet<Integer>) baseSet.clone();
                } else {
                    set.clear();
                }
            } else {
                int num = Integer.parseInt(st.nextToken());
                if ("add".equals(operation)) {
                    set.add(num);
                } else if ("remove".equals(operation)) {
                    set.remove(num);
                } else if ("check".equals(operation)) {
                    bw.write((set.contains(num)? 1: 0) +"\n");
                } else if ("toggle".equals(operation)) {
                    if(set.contains(num)){
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                }
            }

        }
        bw.flush();
    }
}
