#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N = 5, sum = 0, temp;

	int arr[N];

	for(int i = 0; i < N; i++){
		scanf("%d", &arr[i]);
		sum += arr[i];
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
	printf("%d\n%d", sum/N, arr[N/2]);
}

