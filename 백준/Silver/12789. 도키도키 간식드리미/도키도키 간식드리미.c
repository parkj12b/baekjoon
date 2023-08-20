#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>


typedef struct{
	int* arr;
	int size;
	int top;
} IntStack;

void init_stack(IntStack* s, int size){
	s-> top = 0;
	s-> size = size;
	s->arr = (int*)malloc(sizeof(int)*size);
}

int isEmpty(IntStack* s){
	if(s->top == 0){
		return 1;
	} else {
		return 0;
	}
}

int isFull(IntStack* s){
	if(s->top == s->size){
		return 1;
	} else {
		return 0;
	}	
}

bool push(IntStack* s, int num){
	if(isFull(s)){
		return false;
	} else {
		s->arr[s->top] = num;
		s->top++;
	}
}

int pop(IntStack* s){
	if(isEmpty(s)){
		return -1;
	} else {
		int num = s->arr[s->top-1];
		s->top--;
		return num;
	}
}

int stackSize(IntStack* s){
	return s->top;
}

int peek(IntStack* s){
	if(isEmpty(s)){
		return -1;
	} else {
		return s->arr[s->top-1];
	}	
}

int main(){
	IntStack line1;
	IntStack waiting;
	init_stack(&line1, 1000);
	init_stack(&waiting, 1000);

	int num, N;
	int nextNum = 1;
	bool popped = false;

	int arr[1000] = {0};
	scanf("%d", &N);

	for(int i = 0; i < N; i++){
		scanf("%d", &num);

		arr[i] = num;
	}
	for(int i = 0; i < N; i++){
		push(&line1, arr[N-i-1]);
	}
	while(nextNum <= N){
		if(!isEmpty(&line1)){
			if(popped){
				if(peek(&waiting) == nextNum){
					pop(&waiting);
					popped = true;
					nextNum++;
				} else if(peek(&line1) == nextNum) {
					pop(&line1);
					popped = true;
					nextNum++;
				} else {
					push(&waiting, pop(&line1));
					popped = false;
				}
			}
			else if(peek(&line1) != nextNum){
				push(&waiting, pop(&line1));
				popped = false;
			} else {
				pop(&line1);
				popped = true;
				nextNum++;
			}
		} else {
			if(peek(&waiting) != nextNum){
				break;
			} else {
				pop(&waiting);
				nextNum++;
			}
		}
	}
	if(isEmpty(&line1) && isEmpty(&waiting)){
		printf("Nice");
	} else {
		printf("Sad");
	}	
}
