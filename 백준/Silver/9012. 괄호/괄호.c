#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

int main(){
	int N;
	scanf("%d", &N);

	char str[51];

	for(int i = 0; i < N; i++){
		scanf("%s", str);
		int length = strlen(str);
		int counter = 0;
		bool isGood = true;
		
		for(int j = 0; j < length; j++){
			if(str[j] == '('){
				counter++;
			} else {
				counter--;
			}
			if(counter < 0){
				isGood = false;
				break;
			}
		}
		if(counter != 0 || !isGood){
			printf("NO\n");
		} else {
			printf("YES\n");
		}
	}

}
