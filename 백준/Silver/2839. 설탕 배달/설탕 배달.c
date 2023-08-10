#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>



int main()
{
	int N, numBags=0;
	scanf("%d", &N);


	while(N > 0){
		if(N % 5 == 0){
			numBags += N/5;
			N = 0;
		} else {
			N -= 3;
			numBags++;
		}
	}
	if(N < 0){
		printf("-1");
	} else {
		printf("%d", numBags);
	}
}
