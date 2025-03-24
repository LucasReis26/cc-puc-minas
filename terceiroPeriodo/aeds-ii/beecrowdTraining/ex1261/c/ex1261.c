#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	int quant_palavras,
		quant_descricoes;

	scanf("%d %d",&quant_palavras, &quant_descricoes);

	int *values = (int *)malloc(quant_palavras * sizeof(int));
	char **words = (char **)malloc(quant_palavras * sizeof(char *));
	
	for(int i = 0; i < quant_palavras; i++){
		words[i] = (char *)malloc(255*sizeof(char));
		scanf("%s",words[i]);
		scanf("%d",&values[i]);
		getchar();
	}

	for(int i = 0; i < quant_descricoes; i++){

		char *w = (char *)malloc(255*sizeof(char));
		int descriptionValue = 0;

		do{
			scanf("%s",w);
			for(int j = 0; j < quant_palavras; j++){
				if(strcmp(w,words[j]) == 0){
					descriptionValue += values[j];
					j = quant_palavras;
				}
			}

		}while(strcmp(w,".") != 0);
		
		printf("%d\n",descriptionValue);

		free(w);

	}

	for(int i = 0; i < quant_palavras; i++){
		free(words[i]);
	}
	free(words);
	free(values);

	return 0;
}
