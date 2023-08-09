#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int max, a,b,c;
	scanf("%d %d %d", &a, &b, &c);
	max = a;

	if(b > max) max = b;
	if(c > max) max = c;

	int sum = a+b+c;
	int otherTwo = sum - max;

	if(otherTwo > max){
		printf("%d", sum);
	} else {
		printf("%d", otherTwo*2-1);
	}
	
}
	
