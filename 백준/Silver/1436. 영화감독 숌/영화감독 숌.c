#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
int main()
{
	int N, occurence = 0, counter = 0, num = 666;
	scanf("%d", &N);
	int temp = 0;
	while(occurence < N){
		counter = 0;
		temp = num;
		while(temp > 0){
			if(temp %10 == 6){
				counter++;
			} else {
				counter = 0;
			}
			temp /= 10;

			if(counter == 3){
				occurence++;
				break;
			}
		}
		if(occurence == N) break;
		num++;
	}
	printf("%d", num);
}
