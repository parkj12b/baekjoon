import java.io.*;
import java.util.*;

public class Main {
    static char[] op = { '+', '-', '*', '/' };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        //f: 총 f 층
        //g: 목표 층
        //s: 현재 층
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int counter = 0;

        q.add(s);
        set.add(s);
        
        while(!q.isEmpty()){
            for(int i = 0, length = q.size(); i < length; i++){
                int num = q.poll();
                if(num == g){
                    System.out.println(counter);
                    return ;
                }
                int up = num + u;
                int down  = num - d;

                if(up <= f && !set.contains(up)){
                    q.add(up);
                    set.add(up);
                }
                if(down >= 1 && !set.contains(down)){
                    q.add(down);
                    set.add(down);
                }
            }
            counter++;
        }
        System.out.println("use the stairs");
    }
}