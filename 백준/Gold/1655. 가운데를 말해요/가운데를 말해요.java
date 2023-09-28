import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<Integer>((e1, e2) -> {
            return e2 - e1;
        });
        PriorityQueue<Integer> right = new PriorityQueue<Integer>();

        int n = Integer.parseInt(br.readLine());
        int leftSize = 0;
        int rightSize = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (leftSize == 0) {
                left.add(num);
                leftSize++;
            } else if (left.peek() > num) {
                left.add(num);
                leftSize++;
                if (leftSize - 1 > rightSize) {
                    right.add(left.poll());
                    rightSize++;
                    leftSize--;
                }

            } else {
                right.add(num);
                rightSize++;
                if (rightSize > leftSize) {
                    left.add(right.poll());
                    leftSize++;
                    rightSize--;
                }
            }
            sb.append(left.peek()).append("\n");

            // System.out.println("left: " + left.size());
            // System.out.println("right: " + right.size());
        }
        System.out.print(sb);
    }
}