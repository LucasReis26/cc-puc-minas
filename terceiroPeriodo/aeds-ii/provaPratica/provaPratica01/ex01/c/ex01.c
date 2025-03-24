#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int descobrePadrao(char *w){
	int resp = 0;
	if(strlen(w) == 7){
		bool v1 = (w[0] >= 'A' && w[0] <= 'Z');
		bool v2 = (w[1] >= 'A' && w[1] <= 'Z');
		bool v3 = (w[2] >= 'A' && w[2] <= 'Z');
		bool v4 = (w[3] >= '0' && w[3] <= '9');
		bool v5 = (w[4] >= 'A' && w[4] <= 'Z');
		bool v6 = (w[5] >= '0' && w[5] <= '9');
		bool v7 = (w[6] >= '0' && w[6] <= '9');

		if(v1 && v2 && v3 && v4 && v5 && v6 && v7){
			resp = 2;
		}
	}
	if(strlen(w) == 8){
		bool v1 = (w[0] >= 'A' && w[0] <= 'Z');
		bool v2 = (w[1] >= 'A' && w[1] <= 'Z');
		bool v3 = (w[2] >= 'A' && w[2] <= 'Z');
		bool v4 = (w[3] >= '-' && w[3] <= '-');
		bool v5 = (w[4] >= '0' && w[4] <= '9');
		bool v6 = (w[5] >= '0' && w[5] <= '9');
		bool v7 = (w[6] >= '0' && w[6] <= '9');
		bool v8 = (w[7] >= '0' && w[6] <= '9');

		if(v1 && v2 && v3 && v4 && v5 && v6 && v7){
			resp = 1;
		}
	}

	return resp;
}
int main(){
	char *linha = (char *)malloc(255*sizeof(char));

	fgets(linha,255,stdin);
	int len = strlen(linha);
	if(strlen(linha) > 0 && linha[len - 1] == '\n'){
		linha[len - 1] = '\0';
	}

	printf("%d\n",descobrePadrao(linha));

	free(linha);
	return 0;
}
