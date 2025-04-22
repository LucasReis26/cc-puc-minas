#include "myutils.h"
#include <stdio.h>

void printArray(int *array, int len){
	printf("\n[ ");

	for(int i = 0; i < len; i++){
		printf("%d, ",array[i]);
	}

	printf("]\n");
}

void swap(int *a, int *b){
	int aux = *a;
	*a = *b;
	*b = aux;
}
