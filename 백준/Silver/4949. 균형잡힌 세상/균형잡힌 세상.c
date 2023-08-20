#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char* s;
	char* stack;
	int top = 0;
	bool isGood = true;
	
	s = (char *)malloc(sizeof(char)*102);
	stack = (char*)malloc(sizeof(char)*102);

	fgets(s, 102, stdin);
	while(true){
		top = 0;
		isGood = true;
		if(strcmp(s,".\n")==0){
			break;
		}
		for(int i = 0, length = strlen(s); i < length; i++){
			if(s[i] == '(' || s[i] == '['){
				stack[top] = s[i];
				top++;
			} else if(s[i] == ')' || s[i] == ']'){
				if(top == 0){
					isGood = false;
					break;
				} else if(s[i] == ')' && stack[top-1] == '('){
					top--;
				} else if(s[i] == ']' && stack[top-1] == '['){
					top--;
				} else {
					isGood = false;
					break;
				}
			}
		}
		if(isGood && top == 0){
			printf("yes\n");
		} else {
			printf("no\n");
		}

		fgets(s, 102, stdin);
	}
	free(s);
	free(stack);
}
