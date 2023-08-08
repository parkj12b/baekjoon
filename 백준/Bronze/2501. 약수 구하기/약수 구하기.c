#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N, K, counter = 0;
	bool notFound = true;
	scanf("%d %d", &N, &K);

	for(int i = 1; i <= N; i++){
		if(N % i == 0){
			counter++;
			if(counter == K){
				printf("%d", i);
				notFound = false;
				break;
			}
		}
	}
	if(notFound){
		printf("0");
	}
}
