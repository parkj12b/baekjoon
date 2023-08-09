#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int x1, y1, x2, y2, x3, y3, ansX, ansY;
	scanf("%d %d %d %d %d %d", &x1, &y1, &x2, &y2, &x3, &y3);

	if(x1 == x2 && y1 == y3){
		ansX = x3;
		ansY = y2;
	}
	else if(x1 == x3 && y1 == y2){
		ansX = x2;
		ansY = y3;
	}
	else if(x2 == x3 && y2 == y1){
		ansX = x1;
		ansY = y3;
	}
	else if(x1 == x2 && y3 == y2){
		ansX = x3;
		ansY = y1;
	}
	else if(x1 == x3 && y2 == y3){
		ansX = x2;
		ansY = y1;
	}
	else if(x3 == x2 && y1 == y3){
		ansX = x1;
		ansY = y2;
	}
	printf("%d %d", ansX, ansY);
}
