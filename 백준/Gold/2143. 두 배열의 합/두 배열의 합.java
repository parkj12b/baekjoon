import java.io.*;
import java.util.*;

public class Main {

    static boolean[] prime;
    static int N, S;
    static long[] arr;
    static long counter = 0;
    static ArrayList<Long> listA = new ArrayList<>();
    static ArrayList<Long> listB = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long T = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int M = Integer.parseInt(br.readLine());
        long[] B = new long[M];
        B = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        getSubSequence(A, listA);
        getSubSequence(B, listB);

        Collections.sort(listA);
        Collections.sort(listB);

        int p1 = 0;
        int p2 = listB.size()-1;
        while(p1 < listA.size() && p2 >= 0){
            long partialSum = listA.get(p1) + listB.get(p2);
            long eleA = listA.get(p1);
            long eleB = listB.get(p2);
            if(partialSum == T){
                long cntA = 0;
                long cntB = 0;

                while(p1 < listA.size() && listA.get(p1) == eleA){
                    cntA++;
                    p1++;
                }
                while(p2 >= 0 && listB.get(p2) == eleB){
                    cntB++;
                    p2--;
                }
                counter += cntA*cntB;
            } else if(partialSum < T){
                p1++;
            } else {
                p2--;
            }
        }
        
        System.out.println(counter);
    }

    static void getSubSequence(long[] arr, ArrayList<Long> list) {
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            long sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                list.add(sum);
            }
        }
    }
    
}