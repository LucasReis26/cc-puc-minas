#include "heapsort.h"
#include "myutils.h"
#include <stdlib.h>

void heapsort(int *array, int len){
	int *tmp = (int *)malloc((len + 1) * sizeof(int));

	for(int i = 0; i < len; i++){
		tmp[i + 1] = array[i];
	}

	for(int tamHeap = 2; tamHeap <= len; tamHeap++){
		construir(tmp,tamHeap);
	}

	int tamHeap = len;
	while(tamHeap > 1){
		swap(&tmp[1],&tmp[tamHeap--]);
		reconstruir(tmp,tamHeap);
	}

	for(int i = 0; i < len; i++){
		array[i] = tmp[i + 1];
	}

	free(tmp);
}

void construir(int *array, int len){
	for(int i = len; i > 1 && array[i] > array[i/2]; i/=2){
		swap(&array[i],&array[i/2]);
	}
}

void reconstruir(int *array, int len){
	int i = 1;
	while(i <= (len/2)){
		int filho = getMaiorFilho(array,i,len);
		if(array[i] < array[filho]){
			swap(&array[i],&array[filho]);
			i = filho;
		}else{
			i = len;
		}
	}
}

int getMaiorFilho(int *array, int i, int len){
	int filho;
	if(2 * i == len || array[2 * i] > array[(2 * i) + 1]){
		filho = 2 * i;
	}else{
		filho = (2 * i) + 1;
	}
	return filho;
}
