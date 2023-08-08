#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N;
	int arr[1000];
	int counter = 0;
	int index = 0;
	scanf("%d", &N);
	while(N != -1){
		counter = 0;
		index = 0;
		memset(arr, '\0',sizeof(arr));
		for(int i = 1; i <= N/2; i++){
			if(N%i == 0){
				counter += i;
				arr[index] = i;
				index++;
			}
		}
		if(counter == N){
			printf("%d = ", N);
			for(int i = 0; i < index; i++){
				if(i == index-1){
					printf("%d\n", arr[i]);
				} else {
					printf("%d + ", arr[i]);
				}
			}
		} else {
			printf("%d is NOT perfect.\n", N);
		}
		scanf("%d", &N);
	}
}
