#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int min(int a, int b){
	return (a) > (b) ? (b) : (a);
}

void merge(int arr[], int left, int mid, int right){
	int i, j, k;
	int n1 = mid - left + 1;
	int n2 = right - mid;
	
	int L[n1], R[n2];
	for(i = 0; i < n1; i++){
		L[i] = arr[left+i];
	}
	for(j = 0; j < n2; j++){
		R[j] = arr[mid+1+j];
	}

	i = 0;
	j = 0;
	k = left;

	while(i < n1 && j < n2){
		if(L[i] <= R[j]){
			arr[k] = L[i];
			i++;
		}
		else {
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	while(i < n1){
		arr[k] = L[i];
		i++;
		k++;
	}
	while(j < n2){
		arr[k] = R[j];
		j++;
		k++;
	}

}

void mergeSort(int arr[], int size){
	for(int currentSize = 1; currentSize <= size-1; currentSize *= 2){
		for(int left = 0; left < size-1; left += currentSize*2){
			int mid = min(left + currentSize -1,size-1);
			int right = min(left + 2*currentSize -1,size-1);

			merge(arr, left, mid, right);
		}
	}
}

int main()
{
	int N = 0;
	scanf("%d", &N);
	int arr[N];
	for(int i = 0; i < N; i++){
		scanf("%d", &arr[i]);
	}
	mergeSort(arr, N);
	for(int i = 0; i < N; i++){
		printf("%d\n", arr[i]);
	}
}

