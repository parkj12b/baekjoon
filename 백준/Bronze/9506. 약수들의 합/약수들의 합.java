import java.io.*;
import java.util.*;


public class Main {
    
    static int[] dp;

    public static void main(String[] args) throws IOException{
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        String string1 = "1";
        String string2 = "";

        int sum = 1;
        int p = sc.nextInt();
        boolean firstEle = true;
        while(p != -1) {
            
            for(int i = 2; i <= Math.sqrt(p); i++) {
                if(p % i == 0){
                    sum += i;
                    sum += p/i;
                    string1 = string1 + " + " + i;
                    if(firstEle){
                        string2 += p/i;
                        firstEle = false;
                    } else {
                        string2 = p/i + " + " + string2;
                    }
                }
            }
            
            if(sum == p){
                System.out.println(p +" = " + string1 + " + " + string2);
            } else {
                System.out.println(p + " is NOT perfect.");
            }
            string1 = "1";
            string2 = "";
            sum = 1;
            firstEle = true;
            p = sc.nextInt();
        }
    } 
    
}

