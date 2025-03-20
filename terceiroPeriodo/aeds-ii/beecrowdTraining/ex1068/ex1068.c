#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int analisaExpressao(char *w){

	int resp = 0;
	size_t len = strlen(w);
	int parent = 0;
	
	for(int i = 0; i < len; i++){
		if(w[i] == '('){
			parent++;
		}else if(w[i] == ')' && parent > 0){
			parent--;
		}else if(w[i] == ')' && parent <= 0){
			resp = -1;
			i = len;
		}
	}
	if(parent == 0 && resp != -1)
		resp = 1;
	else
		resp = 0;

	return resp;
}
int main(){
	char *expressao = (char *)malloc(1000*sizeof(char));

	while(scanf("%s",expressao) == 1){
		if(analisaExpressao(expressao) == 1){
			printf("correct\n");
		}else{
			printf("incorrect\n");
		}
	}

	free(expressao);
	return 0;
}
