#include <stdio.h>
#include <stdlib.h>


int main(){
	int quant_palavras,
		quant_descricoes,
		*values = (int *)malloc(quant_palavras * sizeof(int));

	char **words = (char **)malloc(quant_palavras * sizeof(char));
	
	for(int i = 0; i < quant_palavras; i++){
		words[i] = (int *)malloc(255*sizeof(char));
		scanf("%s %d",words[i], values[i]);
		getchar();
	}



	for(int i = 0; i < quant_palavras; i++){
		free(words[i]);
	}
	free(words);
	free(values);

	return 0;
}
