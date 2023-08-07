import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static int[][] map;
    static int[][] diceMap = { { 0, 5, 0, 0 }, { 1, 2, 3, 4 }, { 0, 6, 0, 0 }, { 0, 4, 0, 0 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = 6;
        String input;
        map = new int[N][N];

        int[] diceChecker = new int[7];
        int[][] visit = new int[6][6];
        Stack<Pair> stack = new Stack<>();
        while((input = br.readLine()) != null) {
            stack.clear();
            Arrays.fill(diceChecker, 0);
            for(int i = 0; i < 6; i++) {
                Arrays.fill(visit[i], 0);
            }
            
            map[0] = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 1; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            esc: for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        stack.push(new Pair(i, j, -1));
                        visit[i][j] = 1;
                        break esc;
                    }
                }
            }
            dice: while (!stack.isEmpty()) {
                Pair cur = stack.peek();
                int y = cur.y;
                int x = cur.x;
                for (int j = 0; j < 4; j++) {
                    int newY = y + dy[j];
                    int newX = x + dx[j];

                    if (newY < 0 || newX < 0 || newY >= 6 || newX >= 6 || visit[newY][newX] == 1) {
                        continue;
                    }
                    if (map[newY][newX] == 1) {
                        visit[newY][newX] = 1;
                        stack.push(new Pair(newY, newX, j));
                        rotate(j);
                        continue dice;
                    }
                }
                int direction = cur.direction;
                direction += 2;
                direction %= 4;
                diceChecker[diceMap[1][1]]++;
                rotate(direction);
                stack.pop();
            }
            boolean isDice = true;
            for (int i = 1; i <= 6; i++) {
                if (diceChecker[i] != 1) {
                    isDice = false;
                }
            }
            if (isDice) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
    }

    static class Pair {
        int y, x, direction;

        Pair(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    static void rotate(int direction) {
        if (direction == 0) {
            int temp1 = 0;
            int temp2 = diceMap[3][1];
            for (int i = 0; i < 4; i++) {
                temp1 = diceMap[i][1];
                diceMap[i][1] = temp2;

                temp2 = temp1;
            }
            diceMap[1][3] = diceMap[3][1];
        } else if (direction == 1) {
            int temp1 = 0;
            int temp2 = diceMap[1][0];
            for (int i = 0; i < 4; i++) {
                temp1 = diceMap[1][3 - i];
                diceMap[1][3 - i] = temp2;

                temp2 = temp1;
            }
            diceMap[3][1] = diceMap[1][3];
        } else if (direction == 2) {
            int temp1 = 0;
            int temp2 = diceMap[0][1];
            for (int i = 0; i < 4; i++) {
                temp1 = diceMap[3 - i][1];
                diceMap[3 - i][1] = temp2;
                temp2 = temp1;
            }
            diceMap[1][3] = diceMap[3][1];
        } else if (direction == 3) {
            int temp1 = 0;
            int temp2 = diceMap[1][3];
            for (int i = 0; i < 4; i++) {
                temp1 = diceMap[1][i];
                diceMap[1][i] = temp2;
                temp2 = temp1;
            }
            diceMap[3][1] = diceMap[1][3];
        }
    }
}