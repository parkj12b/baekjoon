import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> letterToInt = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int totalSum = 0;
        int curNum = 9;
        ArrayList<String> words = new ArrayList<>();
        Pair[] pairs = new Pair[map.size()];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            words.add(s);
            int l = s.length();
            for(int j = 0; j < l; j++){
                char c = s.charAt(j);
                if(!map.containsKey(c)){
                    int num = (int) Math.pow(10,l-j);
                    map.put(c,num);
                } else {
                    int num = map.get(c);
                    num += (int) Math.pow(10, l-j);
                    map.put(c, num);
                }
            }
        }
        ArrayList<Pair> list = new ArrayList<>();
        Set<Character> set = map.keySet();
        for(char c : set){
            list.add(new Pair(c,map.get(c)));
        }
        Collections.sort(list, (e1, e2)->{
            return e2.num - e1.num;
        });
        for(int i = 0; i < list.size(); i++){
            char c = list.get(i).c;
            letterToInt.put(c, curNum);
            curNum--;
        }
        for(int i = 0; i < words.size(); i++){
            String s = words.get(i);
            String num = "";
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                num += letterToInt.get(c);
            }
            totalSum += Integer.parseInt(num);
        }
        System.out.println(totalSum);
    }

    static class Pair{
        char c;
        int num;

        Pair(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
}