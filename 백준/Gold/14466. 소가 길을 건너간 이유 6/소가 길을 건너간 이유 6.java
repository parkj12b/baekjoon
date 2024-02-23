import java.util.*;
import java.io.*;

class Main{
  static int[][] map;
  static ArrayList<int[]> bridge = new ArrayList<>();
  static ArrayList<int[]> cows = new ArrayList<>();
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, 1, 0, -1};
  static int N;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");

    N = Integer.parseInt(line[0]);
    int K = Integer.parseInt(line[1]);
    int R = Integer.parseInt(line[2]);

    map = new int[N + 1][N + 1];
    for (int i = 0; i < R; i++)
    {
      line = br.readLine().split(" ");
      int y1 = Integer.parseInt(line[0]);
      int x1 = Integer.parseInt(line[1]);
      int y2 = Integer.parseInt(line[2]);
      int x2 = Integer.parseInt(line[3]);

      bridge.add(new int[]{y1, x1, y2, x2});
    }

    for(int i = 0; i < K; i++)
    {
      line = br.readLine().split(" ");
      cows.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
    }
    
    search();
    int counter = 0;
    for (int i = 0; i < cows.size(); i++)
    {
      int[] cow1 = cows.get(i);
      for (int j = i + 1; j < cows.size(); j++)
      {
        int[] cow2 = cows.get(j);
        if (map[cow1[0]][cow1[1]] != map[cow2[0]][cow2[1]])
          counter++;
      }
    }
    System.out.print(counter);
    // for (int i = 1; i <= N; i++)
    // {
    //   for (int j = 1; j <= N; j++)
    //   {
    //     System.out.print(map[i][j] + " ");
    //   }
    //   System.out.println();
    // }
  }

  static void search() 
  {
    Deque<int[]> queue = new ArrayDeque<>();
    boolean[][] visit = new boolean[N + 1][N + 1];
    int counter = 0;
    for (int i = 0; i < cows.size(); i++)
    {
      if (visit[cows.get(i)[0]][cows.get(i)[1]])
        continue;
      counter++;
      queue.addLast(cows.get(i));
      int y = queue.peek()[0];
      int x = queue.peek()[1];
      map[y][x] = counter;
      visit[y][x] = true;
      while (!queue.isEmpty())
      {
        int[] point = queue.poll();
        y = point[0];
        x = point[1];

        for (int j = 0; j < 4; j++)
        {
          int checkY = y + dy[j];
          int checkX = x + dx[j];

          if (checkX <= 0 || checkX > N || checkY <= 0
            || checkY > N || visit[checkY][checkX])
            continue ;
          if (checkBridge(point, new int[]{checkY, checkX}) == true)
            continue ;
          visit[checkY][checkX] = true;
          map[checkY][checkX] = counter;
          queue.add(new int[]{checkY, checkX});
        }
      }
    }
  }

  static boolean checkBridge(int[] p1, int[] p2)
  {
    for (int i = 0; i < bridge.size(); i++)
    {
      int[] checkBridge = bridge.get(i);
      if (checkBridge[0] == p1[0] && checkBridge[1] == p1[1]
          && checkBridge[2] == p2[0] && checkBridge[3] == p2[1])
          {
            return true;
          }
      if (checkBridge[0] == p2[0] && checkBridge[1] == p2[1]
          && checkBridge[2] == p1[0] && checkBridge[3] == p1[1])
          {
            return true;
          }
    }
    return false;
  }
  
}