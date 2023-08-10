#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

typedef struct{
	int x;
	int y;
} Pair;

int compare(const void *a, const void *b){
	Pair A = *(Pair *)a;
	Pair B = *(Pair *)b;

	return A.y != B.y ? A.y-B.y : A.x-B.x;
}

int main()
{
	int N;
	scanf("%d", &N);
	Pair arr[N];
	for(int i = 0; i < N; i++){
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	qsort(arr, N, sizeof(Pair), compare);
	for(int i = 0; i < N; i++){
		printf("%d %d\n", arr[i].x, arr[i].y);
	}
}

