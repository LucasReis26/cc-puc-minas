#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	char *w1 = (char *)malloc(255*sizeof(char));
	char *w2 = (char *)malloc(255*sizeof(char));

	while(scanf("%s %s",w1,w2) == 2){

		int len1 = strlen(w1),
			len2 = strlen(w2),
			maior = (len1 > len2) ? 1 : 2;

		size_t w3_len = (len1 + len2);
		char *w3 = (char *)malloc(w3_len * sizeof(char));

		for(int i = 0, j = 0, l = 0; i < w3_len; i++){
			if(j < len1 && l < len2){
				if(i % 2 == 0){
					w3[i] = w1[j];
					j++;
				}else{
					w3[i] = w2[l];
					l++;
				}
			}else{
				if(maior == 1){
					w3[i] = w1[j];
					j++;
				}else{
					w3[i] = w2[l];
					l++;
				}
			}
		}

		printf("%s\n",w3);

		free(w3);
	}
	free(w1);
	free(w2);
}
