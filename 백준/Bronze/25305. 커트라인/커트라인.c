#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N, k, temp;
	scanf("%d %d", &N, &k); 
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
	printf("%d\n", arr[N-k]);
}

