#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N, temp;
	scanf("%d", &N);

	int arr[N];

	for(int i = 0; i < N; i++){
		scanf("%d", &arr[i]);
	}

	for(int i = 0; i < N; i++){
		for(int j = 0; j < N-i-1; j++){
			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}

	for(int i = 0; i < N; i++){
		printf("%d\n", arr[i]);
	}
}
