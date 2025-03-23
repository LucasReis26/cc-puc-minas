#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void ordenador(int *array,int len){
	if(array[0] % 2 == 0){
		for(int i = 0; i < len - 1; i++){
			bool swapped = false;
			for(int j = 0; j < len -i -1; j++){
				if(array[j + 1] < array[j]){
					swapped = true;
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			if(!swapped){
				i = len;
			}
		}
	} else {
		for(int i = 0; i < len - 1; i++){
			bool swapped = false;
			for(int j = 0; j < len -i -1; j++){
				if(array[j + 1] > array[j]){
					swapped = true;
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
			if(!swapped){
				i = len;
			}
		}
	}
}

int main(){

	int numCases,
		*array,
		*pares,
		*impares,
		q_pares = 0,
		q_impares = 0;

	scanf("%d",&numCases);

	array = (int *)malloc(numCases*sizeof(int));
	pares = (int *)malloc(numCases*sizeof(int));
	impares = (int *)malloc(numCases*sizeof(int));

	for(int i = 0; i < numCases; i++){
		scanf("%d",&array[i]);
		if(array[i] % 2 == 0){
			pares[q_pares++] = array[i];
		}else{
			impares[q_impares++] = array[i];
		}
	}

	if(q_pares > 0)
		ordenador(pares,q_pares);

	if(q_impares > 0)
		ordenador(impares,q_impares);

	if(q_pares > 0)
		for(int i = 0; i < q_pares; i++){
			printf("%d\n",pares[i]);
		}

	if(q_impares > 0)
		for(int i = 0; i < q_impares; i++){
			printf("%d\n",impares[i]);
		}

	free(array);
	free(pares);
	free(impares);

	return 0;
}
