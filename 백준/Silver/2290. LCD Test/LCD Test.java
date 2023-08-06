import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[33][130];
    static int s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();
        int numLength = n.length();
        for(int i = 0; i < map.length; i++){
            Arrays.fill(map[i], ' ');
        }
        for(int i = 0, length = n.length(); i < length; i++){
            int num = Character.getNumericValue(n.charAt(i));
            // System.out.println(num);
            draw(num, i);
        }
        

        for(int i = 0; i < 2*s+3; i++){
            for(int j = 0; j < (s+3)*numLength; j++){
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        // - to be 1 | to be 2

        

    }
    
    static void draw(int num, int numOrder){
        
        if(num == 1){
            drawSegment(3, numOrder);    
            drawSegment(6, numOrder);    
        } else if(num == 2){
            drawSegment(1, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(5, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 3){
            drawSegment(1, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 4){
            drawSegment(2, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(6, numOrder);    
            
        } else if(num == 5){
            drawSegment(1, numOrder);    
            drawSegment(2, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 6){
            drawSegment(1, numOrder);    
            drawSegment(2, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(5, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 7){
            drawSegment(1, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(6, numOrder);    
            
        } else if(num == 8){
            drawSegment(1, numOrder);    
            drawSegment(2, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(5, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 9){
            drawSegment(1, numOrder);    
            drawSegment(2, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(4, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        } else if(num == 0){
            drawSegment(1, numOrder);    
            drawSegment(2, numOrder);    
            drawSegment(3, numOrder);    
            drawSegment(5, numOrder);    
            drawSegment(6, numOrder);    
            drawSegment(7, numOrder);    
            
        }
    }

    static void drawSegment(int segmentNum, int numOrder){
        int x = numOrder * (s+3);
        int y = 0;
        if(segmentNum == 1){
            for(int i = 0; i < s; i++){
                map[y][x+1+i] = '-';
            }
        } else if(segmentNum == 2){
            for(int i = 0; i < s; i++){
                map[y+i+1][x] = '|';
            }
        } else if(segmentNum == 3){
            for(int i = 0; i < s; i++){
                map[y+i+1][x+s+1] = '|';
            }
        } else if(segmentNum == 4){
            for(int i = 0; i < s; i++){
                map[y+s+1][x+i+1] = '-';
            }
        } else if(segmentNum == 5){
            for(int i = 0; i < s; i++){
                map[y+s+2+i][x] = '|';
            }
        } else if(segmentNum == 6){
            for(int i = 0; i < s; i++){
                map[y+s+2+i][x+s+1] = '|';
            }
        } else if(segmentNum == 7){
            for(int i = 0; i < s; i++){
                map[y+s*2+2][x+i+1] = '-';
            }
        }
    }
}