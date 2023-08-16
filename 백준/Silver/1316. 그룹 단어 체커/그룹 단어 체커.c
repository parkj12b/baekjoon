#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
	char s[101];
	int n;
	scanf("%d", &n);
	int counter = n;
	for(int i = 0; i < n; i++){
		scanf("%s", s);
		int arr[26] = {0};
		arr[s[0]-97]++;
		for(int j = 1, length = strlen(s); j < length; j++){
			if(s[j] != s[j-1]){
				if(arr[s[j] - 97] == 1){
					counter--;
					break;
				}
				arr[s[j] - 97] = 1;
			}
		}
	}
	printf("%d", counter);

}
