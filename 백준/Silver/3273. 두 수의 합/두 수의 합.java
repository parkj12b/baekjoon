import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int X = Integer.parseInt(br.readLine());

        int p1 = 0;
        int p2 = N-1;
        int counter = 0;
        Arrays.sort(arr);
        while(p1 < p2){
            int partialSUm = arr[p1] + arr[p2];

            if(partialSUm < X){
                p1++;
            } else if(partialSUm == X){
                counter++;
                p1++;
                p2--;
            } else {
                p2--;
            }
        }
        System.out.println(counter);
    }
}