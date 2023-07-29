import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static ArrayList<Character> consonant, vowel, allChar, combination;
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(reader.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        consonant = new ArrayList<>();
        vowel = new ArrayList<>();
        combination = new ArrayList<>();
        allChar = new ArrayList<>();
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < C; i++){
            char c = st.nextToken().charAt(0);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel.add(c);
            } else {
                consonant.add(c);
            }
            allChar.add(c);
        }
        Collections.sort(allChar);
        search(0,0,0);
        writer.flush();
    }

    static void search(int index, int numConsonant, int numVowel) throws IOException{
        if(combination.size() == L){
            if(numConsonant > 1 && numVowel > 0){
                for(int i = 0; i < L; i++){
                    writer.write(combination.get(i));
                }
                writer.write("\n");
            }
            return;
        }
        for(int i = index; i < allChar.size(); i++){
            char c = allChar.get(i);
            if(vowel.contains(Character.valueOf(c))){
                combination.add(Character.valueOf(c));
                search(i+1, numConsonant, numVowel+1);
                combination.remove(Character.valueOf(c));
            } else {
                combination.add(Character.valueOf(c));
                search(i+1, numConsonant+1, numVowel);
                combination.remove(Character.valueOf(c));
            }
        }
    }
}
