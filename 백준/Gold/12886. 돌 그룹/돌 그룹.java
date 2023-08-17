import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);

        HashSet<Triplet> tracker = new HashSet<>();
        Queue<Triplet> queue = new LinkedList<>();

        queue.add(new Triplet(num1, num2, num3));
        boolean success = false;
        esc: while(!queue.isEmpty()){
            for(int i = 0, length = queue.size(); i < length; i++){
                Triplet t = queue.poll();
                
                list.set(0, t.num1);
                list.set(1, t.num2);
                list.set(2, t.num3);

                Collections.sort(list);

                num1 = list.get(0);
                num2 = list.get(1);
                num3 = list.get(2);

                if(num1 == num2 && num2 == num3){
                    success = true;
                    break esc;
                }

                if(num1 != num2){
                    Triplet newT = new Triplet(num1*2, num2-num1, num3);
                    if(!tracker.contains(newT)){
                        tracker.add(newT);
                        queue.add(newT);
                    }
                }
                if(num2 != num3){
                    Triplet newT = new Triplet(num1, num2*2, num3-num2);
                    if(!tracker.contains(newT)){
                        tracker.add(newT);
                        queue.add(newT);
                    }
                }
                if(num1 != num3){
                    Triplet newT = new Triplet(num1*2, num2, num3-num1);
                    if(!tracker.contains(newT)){
                        tracker.add(newT);
                        queue.add(newT);
                    }
                }
            }
        }
        if(success){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class Triplet{
        int num1, num2, num3;

        public Triplet(int num1, int num2, int num3){
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
        }

        @Override
        public int hashCode(){
            return num1*17 + num2*31 + num3;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return num1 == triplet.num1 && num2 == triplet.num2 && num3 == triplet.num3;
        }
    }
}