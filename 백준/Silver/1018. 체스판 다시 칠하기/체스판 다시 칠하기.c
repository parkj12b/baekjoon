#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
  int map[2][51][51] = {0}, N, M;
  char str[51];
  scanf("%d %d", &N, &M);

  for (int i = 1; i <= N; i++)
  {
    scanf("%s", str);
    for (int j = 1; j <= M; j++)
    {
      if ((i + j) % 2 == 0)
      {
        if (str[j-1] == 'W')
        {
          map[0][i][j] = map[0][i][j - 1] + 1;
          map[1][i][j] = map[1][i][j - 1];
        }
        else
        {
          map[0][i][j] = map[0][i][j - 1];
          map[1][i][j] = map[1][i][j - 1] + 1;
        }
      }
      else
      {
        if (str[j-1] == 'B')
        {
          map[1][i][j] = map[1][i][j - 1];
          map[0][i][j] = map[0][i][j - 1] + 1;
        }
        else
        {
          map[1][i][j] = map[1][i][j - 1] + 1;
          map[0][i][j] = map[0][i][j - 1];
        }
      }
    }
  }
  int min = 2500;
  for(int i = 2; i <= N; i++){
    for(int j = 1; j <= M; j++){
      map[0][i][j] = map[0][i][j] + map[0][i-1][j];
      map[1][i][j] = map[1][i][j] + map[1][i-1][j];
    }
  }
  for(int i = 8; i <= N; i++){
    for(int j = 8; j <= M; j++){
      int temp = map[0][i][j] - map[0][i-8][j] - map[0][i][j-8] + map[0][i-8][j-8];
      if(temp < min){
        min = temp;
      }
      temp = map[1][i][j] - map[1][i-8][j] - map[1][i][j-8] + map[1][i-8][j-8];
      if(temp < min){
        min = temp;
      }
    }
  }
  printf("%d", min);
}
