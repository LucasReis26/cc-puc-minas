#include <stdio.h>
#include <stdlib.h>

typedef struct{

	char nome[255];
	int peso;
	int idade;
	float altura;

} RENA;

void leRenas(rena *x){
	scanf("%s %d %d %f",x.nome,&x.peso,&x.idade,&x.altura);
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

		free(renas);
	}

	return 0;
}
