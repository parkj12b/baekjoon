import java.io.*;
import java.util.*;

public class Main {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        prime = new boolean[4000001];
        for(int i = 2; i <= 4000000; i++){
            boolean isPrime = true;
            if(prime[i]){
                continue;
            }
            for(int j = 2; j*j <= i; j++){
                if(i% j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                int counter = 2*i;
                while(counter <= 4000000){
                    prime[counter] = true;
                    counter += i;
                }
            }
        }
        int counter = 0;
        ArrayList<Integer> primeList  = new ArrayList<>();
        for(int i = 2; i < 4000000; i++){
            if(!prime[i]){
                counter += i;
                if(counter == N){
                    answer++;
                }
                primeList.add(counter);
            }
        }
        int pointer1 = 0;
        int pointer2 = 0;

        while(pointer2 < primeList.size()){
            int partialSum = primeList.get(pointer2) - primeList.get(pointer1); 
            if(partialSum < N){
                pointer2++;
            } else if(partialSum == N){
                answer++;
                pointer2++;
                pointer1++;
            } else {
                pointer1++;
            }
        }
        System.out.println(answer);
    }

}