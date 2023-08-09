#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int low, high, sum = 0, min = 2e9;
	bool isPrime = true;
	scanf("%d %d", &low, &high);
	for(int i = low; i <= high; i++){
		isPrime = true;
		if(i == 1){
			continue;
		}
		if(i == 2 || i == 3){
			sum+=i;
			if(i < min){
				min = i;
			} 
			continue;
		}

		for(int j = 2; j*j <= i; j++){
			if(i % j == 0){
				isPrime = false;
				break;
			}
		}
		if(isPrime){
			sum += i;
			if(i < min){
				min = i;
			} 
		}
	}
	if(min != 2e9){
		printf("%d\n%d", sum, min);
	} else {
		printf("-1");
	}
}
