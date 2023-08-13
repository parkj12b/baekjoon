import java.io.*;
import java.util.*;

public class Main {

    
    static ArrayList<Set<Integer>> wordList = new ArrayList<>();
    static boolean[] lettersTaken = new boolean[26];
    static int K, N;
    static int maxWord = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 5;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            Set<Integer> set = new HashSet<>();
            int l = s.length();
            for(int j = 0; j < l; j++){
                char c = s.charAt(j);
                if(c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c'){
                    continue;
                }
                set.add(c-'a');
            }
            wordList.add(set);
        }

        lettersTaken['a' - 'a'] = true;
        lettersTaken['n' - 'a'] = true;
        lettersTaken['t' - 'a'] = true;
        lettersTaken['i' - 'a'] = true;
        lettersTaken['c' - 'a'] = true;
        if(K >= 0){
            search(0, 0);
            System.out.println(maxWord);
        } else {
            System.out.println(0);
        }
    }

    // a b c d e f g h i j k l m n o p q r s t u v w x y z
    // antic is a must so skip
    static void search(int depth, int index) {
        if(depth == K){
            int numWord = 0;
            for(int i = 0; i < N; i++){
                boolean canRead = true;
                Set<Integer> set = wordList.get(i);
                for(int num : set){
                    if(!lettersTaken[num]){
                        canRead = false;
                        break;
                    }
                }
                if(canRead){
                    numWord++;
                }
            }
            if(numWord > maxWord) maxWord = numWord;
            return;
        }
        for(int i = index; i < 26; i++){
            if(lettersTaken[i]) continue;
            lettersTaken[i] = true;
            search(depth+1, i+1);
            lettersTaken[i] = false;
        }
        
    }

}