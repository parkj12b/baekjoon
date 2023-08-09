#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main()
{
	int N, x, y, minX, minY, maxX, maxY;
	
	scanf("%d", &N);
	for(int i = 0; i < N; i++){
		scanf("%d %d", &x, &y);
		if(i == 0){
			minX = x;
			minY = y;
			maxX = x;
			maxY = y;
		} else {
			if(x < minX) minX = x;
			if(x > maxX) maxX = x;
			if(y < minY) minY = y;
			if(y > maxY) maxY = y;
		}
	}
	printf("%d", (maxY-minY)*(maxX-minX));
}
	
