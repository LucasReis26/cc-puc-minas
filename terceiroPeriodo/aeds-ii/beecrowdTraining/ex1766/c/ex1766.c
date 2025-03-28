#include <stdio.h>
#include <stdlib.h>

typedef struct{

	char nome[255];
	int peso;
	int idade;
	float altura;

} RENA;

void leRenas(RENA *x){

	scanf("%s %d %d %f",x->nome,&x->peso,&x->idade,&x->altura);
}

int my_strcmp(char *w1, char *w2){

	int len1 = sizeof(w1),
		len2 = sizeof(w2),
		min = (len1 < len2) ? len1 : len2,
		resp = 0;

	for(int i = 0; i < min; i++){

		if(w1[i] > w2[i]){

			resp = 1;
			i = min;

		}else if(w1[i] < w2[i]){

			resp = -1;
			i = min;

		}
	}

	if(resp == 0 && len1 != len2){

		resp = (len1 > len2) ? 1 : -1;
	}

	return resp;
}

void ordenaRenas(RENA *array){

	int len = sizeof(array);

	for(int i = 0; i < len; i++){

		int maior = i;

		for(int j = i + 1; j < len; j++){

			if(array[maior].peso < array[j].peso){

				maior = j;

			}else if(array[maior].peso == array[j].peso){

				if(array[maior].idade > array[j].idade){

					maior = j;

				}else if(array[maior].idade == array[j].idade){

					if(array[maior].altura > array[j].altura){

						maior = j;

					}else if(array[maior].altura) == array[j].altura){

						if(my_strcmp(array[maior].nome,array[j].nome) == 1){

							maior = j;

						}

					}

				}
			}
		}
	}
}

int main(){

	int numCases;

	scanf("%d",&numCases);

	for(int i = 0; i < numCases; i++){

		printf("CENARIO {%d}\n", (i + 1));

		int totalRenas,
			renasTreno;

		scanf("%d %d",&totalRenas, &renasTreno);

		RENA *renas = (RENA *)malloc(totalRenas*sizeof(RENA));

		for(int j = 0; j < totalRenas; j++){

			leRenas(&renas[j]);
		}

		ordenaRenas(renas);

		free(renas);
	}

	return 0;
}
