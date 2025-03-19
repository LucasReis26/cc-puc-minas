#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void removeEnter(char *w){
	if(strlen(w) > 0 && w[strlen(w) - 1] == '\n')
		w[strlen(w) - 1] = '\0';
}
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
			resp = 0;
			i = len;
		}
	}
	if(parent == 0){
		resp = 1;
	}else{
		resp = 0;
	}

	return resp;
}
int main(){
	char *expressao = (char *)malloc(1000*sizeof(char));

	while(fgets(expressao,sizeof(expressao),stdin) != NULL){
		removeEnter(expressao);
		if(analisaExpressao(expressao)){
			printf("correct\n");
		}else{
			printf("incorrect\n");
		}
	}

	free(expressao);
	return 0;
}
