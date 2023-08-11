#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>


int compare(const void* a, const void* b){
	const int* A = a;
	const int* B = b;
	return (*A)-(*B);
}

int main()
{
	int N = 0,M = 0; 
	int num;
	scanf("%d", &N);
	int arr[N];

	for(int i = 0; i < N; i++){
		scanf("%d", &arr[i]);
	}
	qsort(arr, N, sizeof(int), compare);

	scanf("%d", &M);
	int low, mid, high;
	for(int i = 0; i < M; i++){
		scanf("%d", &num);
		low = 0;
		mid = 0;
		high = N-1;
		while(low <= high){
			mid = (low+high)/2;
			if(arr[mid] == num){
				break;
			}
			else if(arr[mid] < num){
				low = mid+1;
			} else {
				high = mid -1;
			}
		}
		if(low > high){
			printf("0 ");
		} else {
			printf("1 ");
		}
	}
}

