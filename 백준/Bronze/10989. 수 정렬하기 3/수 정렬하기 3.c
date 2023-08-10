#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
int main()
{
	int arr[10001] = {0};
	int N, num;

	scanf("%d", &N);
	for(int i = 0; i < N; i++){
		scanf("%d", &num);
		arr[num]++;
	}
	for(int i = 1; i < 10001; i++){
		if(arr[i] > 0){
			for(int j = 0; j < arr[i]; j++){
				printf("%d\n", i);
			}
		}
	}
}

