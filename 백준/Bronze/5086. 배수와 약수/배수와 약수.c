#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int a, b;

	scanf("%d %d",&a, &b);
	while(!(a == 0 && b == 0)){
		if(a == 0 && b == 0){
			break;
		}
		else if(b/a > 1 && b % a == 0){
			printf("factor\n");
		} else if(a/b > 1 && a % b == 0){
			printf("multiple\n");
		} else {
			printf("neither\n");
		}
		scanf("%d %d",&a, &b);
	}
}
