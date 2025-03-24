#include <stdio.h>
#include <stdlib.h>

int main(){
	int quant_palavras,
		quant_descricoes,
		*values = (int *)malloc(quant_palavras * sizeof(int));

	char **words = (char **)malloc(quant_palavras * sizeof(char));
	

	free(words);
	free(values);

	return 0;
}
