import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { -1, 0, 1, 0 };

        int N = Integer.parseInt(br.readLine());
        int dimensionX = 1 + (N - 1) * 4;
        int dimensionY = dimensionX + 2;
        if (N == 1) {
            dimensionY = 1;
        }
        boolean[][] arr = new boolean[dimensionY][dimensionX];

        int y = 0;
        int x = dimensionX - 1;

        int direction = 0;

        while (true) {
            arr[y][x] = true;
            if (N == 1) {
                break;
            }
            if (y == (dimensionY + 1) / 2 && x == dimensionX / 2) {
                break;
            }
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            int checkY = y + dy[direction] * 2;
            int checkX = x + dx[direction] * 2;
            if (nextY < 0 || nextX < 0 || nextY == dimensionY || nextX == dimensionX
                    || (checkY < dimensionY && checkX < dimensionX && checkX >= 0 && checkY >= 0
                            && arr[y + dy[direction] * 2][x + dx[direction] * 2] == true)) {
                direction++;
                direction %= 4;
            }

            y = y + dy[direction];
            x = x + dx[direction];
        }
        int indexKeeper = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimensionY; i++) {
            indexKeeper = 0;
            sb.setLength(0);
            for (int j = 0; j < dimensionX; j++) {
                if (arr[i][j]) {
                    while (indexKeeper < j) {
                        sb.append(" ");
                        indexKeeper++;
                    }
                    sb.append("*");
                    indexKeeper++;
                }
            }
            bw.write(sb.toString());
            if (i != dimensionY - 1) {
                bw.write("\n");
            }
        }
        bw.flush();
    }
}
