#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

int main(){
	int arr[100000] = {0};
	int N, top = 0;
	int num, counter = 0;

	scanf("%d", &N);
	for(int i = 0; i < N; i++){
		scanf("%d", &num);
		
		if(num == 0){
			counter -= arr[top-1];
			top--;
		} else {
			arr[top] = num;
			counter+=num;
			top++;
		}
	}

	printf("%d", counter);
	
}
