import java.io.*;
import java.util.*;

public class Main {
    static int[][] gears;
    static int[][] sidesIndex;
    static int N;
    static int[] gearTurn;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        gears = new int[N][8];
        gearTurn = new int[N];
        sidesIndex = new int[N][2];

        for(int i = 0; i < N; i++){
            gears[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            sidesIndex[i][0] = 6;
            sidesIndex[i][1] = 2;
        }

        int numTurn = Integer.parseInt(br.readLine());

        for(int i = 0; i < numTurn; i++){
            st = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int tempDirection = direction;
            Arrays.fill(gearTurn, 0);
            gearTurn[gearNum-1] = direction;
            
            for(int j = gearNum-2; j >= 0; j--){
                int leftGear = sidesIndex[j][1];
                int rightGear = sidesIndex[j+1][0];
                if(gears[j][leftGear] != gears[j+1][rightGear]){
                    tempDirection *= -1;
                    gearTurn[j] = tempDirection;
                } else {
                    break;
                }
            }
            tempDirection = direction;
            for(int j = gearNum; j < N; j++){
                int leftGear = sidesIndex[j-1][1];
                int rightGear = sidesIndex[j][0];
                if(gears[j-1][leftGear] != gears[j][rightGear]){
                    tempDirection *= -1;
                    gearTurn[j] = tempDirection;
                } else {
                    break;
                }
            }
            for(int j = 0; j < N; j++){
                if(gearTurn[j] == 1){
                    sidesIndex[j][0] -= 1;
                    sidesIndex[j][1] -= 1;
                    if(sidesIndex[j][0] == -1){
                        sidesIndex[j][0] = 7;
                    }
                    if(sidesIndex[j][1] == -1){
                        sidesIndex[j][1] = 7;
                    }
                } else if(gearTurn[j] == -1) {
                    sidesIndex[j][0] = (sidesIndex[j][0] + 1) % 8;
                    sidesIndex[j][1] = (sidesIndex[j][1] + 1) % 8;
                }
            }

        }
        int counter = 0;
        for(int i = 0; i < N; i++){
            int start = (sidesIndex[i][0] + 2) % 8;
            
            if(gears[i][start] == 1) counter++;
        }
        System.out.println(counter);

    }
    
}