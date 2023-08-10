#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int compare(const void* a, const void* b){
	const char* A = a;
	const char* B = b;
	int lenA = strlen(A);
	int lenB = strlen(B);
	return lenA != lenB ? lenA-lenB : strcmp(A,B); 
}

int main()
{
	int N; 
	scanf("%d", &N);
	char arr[N][51];
	for(int i = 0; i < N; i++){
		scanf("%s", arr[i]);
	}
	qsort(arr, N, sizeof(arr[0]), compare);
	printf("%s\n", arr[0]);
	for(int i = 1; i < N; i++){
		if(strcmp(arr[i-1], arr[i]) != 0){
			printf("%s\n", arr[i]);
		}
	}
}

