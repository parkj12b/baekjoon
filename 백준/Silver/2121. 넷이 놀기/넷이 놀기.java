import java.io.*;
import java.util.*;

public class Main {
    static int width, height;
    static HashSet<Pair> set;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Pair(x, y));
        }
        int counter = 0;
        for(Pair p : set){
            if(rectangleCheck(p))
                counter++;
        }
        System.out.println(counter);
    }

    public static boolean rectangleCheck(Pair p){
        int y = p.y;
        int x = p.x;

        if (set.contains(new Pair(x + width, y)) && 
            set.contains(new Pair(x, y + height)) &&
            set.contains(new Pair(x + width, y + height))){
                return true;
        }
        return false;
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o){
            Pair p = (Pair) o;
            if(p.x == this.x && p.y == this.y)
                return true;
            return false; 
        }

        @Override
        public int hashCode() {
            return Objects.hash((y + x) * y * x);
        }
    }
}