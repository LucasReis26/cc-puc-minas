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
		// printf("O valor do i é: %d\n",i);
		scanf("%s",words[i]);
		scanf("%d",&values[i]);
		getchar();
		// printf("Palavra: %s, custa: %d\n",words[i],values[i]);
	}

	for(int i = 0; i < quant_descricoes; i++){

		char *w = (char *)malloc(255*sizeof(char));
		int descriptionValue = 0;

		do{
			scanf("%s",w);
			// printf("Palavra escaneada: %s\n",w);
			for(int j = 0; j < quant_palavras; j++){
				// printf("Palavra testada: %s\n",words[j]);
				if(strcmp(w,words[j]) == 0){
					descriptionValue += values[j];
					// printf("%s eh igual a %s\n",w,words[j]);
					j = quant_palavras;
				}
			}

		}while(strcmp(w,".") != 0);
		
		printf("%d\n",descriptionValue);

		free(w);

	}

	// for(int i = 0; i < quant_palavras; i++){
	// 	free(words[i]);
	// }
	free(words);
	free(values);

	return 0;
}
