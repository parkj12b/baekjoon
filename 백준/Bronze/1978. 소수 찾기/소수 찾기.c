#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N, num, counter = 0;
	bool isPrime = true;
	scanf("%d", &N);
	for(int i = 0; i < N; i++){
		isPrime = true;
		scanf("%d", &num);
		if(num == 1){
			continue;
		}
		if(num == 2 || num == 3){
			counter++;
			continue;
		}

		for(int j = 2; j*j <= num; j++){
			if(num % j == 0){
				isPrime = false;
				break;
			}
		}
		if(isPrime){
			counter++;
		}
	}
	printf("%d", counter);
}
