#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

typedef struct {
	int age;
	char name[101];
} Person;

int compare(const void* a, const void* b){
	const Person* A = a;
	const Person* B = b;

	return (*A).age != (*B).age ? (*A).age - (*B).age : 0;
}

int main()
{
	int N; 
	scanf("%d", &N);
	Person arr[N];

	for(int i = 0; i < N; i++){
		scanf("%d %s", &arr[i].age, arr[i].name);
	}
	qsort(arr, N, sizeof(Person), compare);

	for(int i = 0; i < N; i++){
		printf("%d %s\n", arr[i].age, arr[i].name);
	}
}

