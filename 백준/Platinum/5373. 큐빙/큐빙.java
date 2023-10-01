import java.io.*;
import java.util.*;

public class Main {
    static char[][][] map = new char[7][4][4];
    static HashMap<Character, Integer> sides = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        initSide();
        
        int n = Integer.parseInt(br.readLine());
        
        while (n-- > 0) {
            initMap();
            int numRotations = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numRotations; i++) {
                String[] strSplit = st.nextToken().split("");
                int side = sides.get(strSplit[0].charAt(0));
                int count = 0;
                if(strSplit[1].charAt(0) == '+'){
                    count = 1;
                } else{
                    count = 3;
                }
                rotation(side, count);
            }
            printTop();
        }
        System.out.print(sb);
    }

    static void printTop(){
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                sb.append(map[1][i][j]);
            }
            sb.append("\n");
        }
    }


    static void rotation(int side, int count) {
        char[][] temp = new char[4][4];
        for(int i = 0; i < count; i++) {
            if(side == 1){
                for(int j = 0; j <= 3; j++){
                    temp[j] = map[2][j].clone();
                }
            } else if(side == 6){
                for(int j = 0; j <= 3; j++){
                    temp[j] = map[3][j].clone();
                }
            } else {
                for(int j = 0; j <= 3; j++){
                    temp[j] = map[1][j].clone();
                }
            }
            if(side == 1){
                map[2][1][1] = map[3][1][1];
                map[2][1][2] = map[3][1][2];
                map[2][1][3] = map[3][1][3];
    
                map[3][1][1] = map[4][1][1];
                map[3][1][2] = map[4][1][2];
                map[3][1][3] = map[4][1][3];
    
                map[4][1][1] = map[5][1][1];
                map[4][1][2] = map[5][1][2];
                map[4][1][3] = map[5][1][3];
                
                map[5][1][1] = temp[1][1];
                map[5][1][2] = temp[1][2];
                map[5][1][3] = temp[1][3];
            } else if(side == 2){
                map[1][1][1] = map[5][3][3];
                map[1][2][1] = map[5][2][3];
                map[1][3][1] = map[5][1][3];
    
                map[5][3][3] = map[6][3][1];
                map[5][2][3] = map[6][2][1];
                map[5][1][3] = map[6][1][1];
    
                map[6][3][1] = map[3][1][1];
                map[6][2][1] = map[3][2][1];
                map[6][1][1] = map[3][3][1];
                
                map[3][1][1] = temp[1][1];
                map[3][2][1] = temp[2][1];
                map[3][3][1] = temp[3][1];
            } else if(side == 3){
                map[1][3][1] = map[2][3][3];
                map[1][3][2] = map[2][2][3];
                map[1][3][3] = map[2][1][3];
    
                map[2][3][3] = map[6][3][3];
                map[2][2][3] = map[6][3][2];
                map[2][1][3] = map[6][3][1];
    
                map[6][3][3] = map[4][1][1];
                map[6][3][2] = map[4][2][1];
                map[6][3][1] = map[4][3][1];
                
                map[4][1][1] = temp[3][1];
                map[4][2][1] = temp[3][2];
                map[4][3][1] = temp[3][3];
            } else if(side == 4){
                map[1][1][3] = map[3][1][3];
                map[1][2][3] = map[3][2][3];
                map[1][3][3] = map[3][3][3];
    
                map[3][1][3] = map[6][3][3];
                map[3][2][3] = map[6][2][3];
                map[3][3][3] = map[6][1][3];
    
                map[6][3][3] = map[5][3][1];
                map[6][2][3] = map[5][2][1];
                map[6][1][3] = map[5][1][1];
                
                map[5][3][1] = temp[1][3];
                map[5][2][1] = temp[2][3];
                map[5][1][1] = temp[3][3];
            } else if(side == 5){
                map[1][1][1] = map[4][1][3];
                map[1][1][2] = map[4][2][3];
                map[1][1][3] = map[4][3][3];
    
                map[4][1][3] = map[6][1][3];
                map[4][2][3] = map[6][1][2];
                map[4][3][3] = map[6][1][1];
    
                map[6][1][3] = map[2][3][1];
                map[6][1][2] = map[2][2][1];
                map[6][1][1] = map[2][1][1];
                
                map[2][3][1] = temp[1][1];
                map[2][2][1] = temp[1][2];
                map[2][1][1] = temp[1][3];
            } else {
                map[3][3][1] = map[2][3][1];
                map[3][3][2] = map[2][3][2];
                map[3][3][3] = map[2][3][3];
    
                map[2][3][1] = map[5][3][1];
                map[2][3][2] = map[5][3][2];
                map[2][3][3] = map[5][3][3];
    
                map[5][3][1] = map[4][3][1];
                map[5][3][2] = map[4][3][2];
                map[5][3][3] = map[4][3][3];
                
                map[4][3][1] = temp[3][1];
                map[4][3][2] = temp[3][2];
                map[4][3][3] = temp[3][3];
            }
            rotateMid(side);
        }
        
    }

    static void rotateMid(int side){
        char[][] temp = new char[4][4];
        for(int i = 1; i <= 3; i++){
            temp[i] = map[side][i].clone();
        }
        if(side == 6){
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    map[side][i][j] = temp[j][4 - i];
                }
            }
        } else {
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    map[side][i][j] = temp[4-j][i];
                }
            }
        }
    }

    static void initSide() {
        sides.put('U', 1);
        sides.put('L', 2);
        sides.put('F', 3);
        sides.put('R', 4);
        sides.put('B', 5);
        sides.put('D', 6);

    }

    static void initMap() {
        for (int i = 1; i <= 6; i++) {
            char c = '0';
            switch (i) {
                case 1:
                    c = 'w';
                    break;
                case 2:
                    c = 'g';
                    break;
                case 3:
                    c = 'r';
                    break;
                case 4:
                    c = 'b';
                    break;
                case 5:
                    c = 'o';
                    break;
                case 6:
                    c = 'y';
            }
            for (int j = 1; j <= 3; j++) {
                Arrays.fill(map[i][j], c);
            }
        }
    }

}