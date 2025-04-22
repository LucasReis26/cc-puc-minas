#include "myutils.h"
#include <stdio.h>

void printArray(int *array, int len){
	printf("\n[ ");

	for(int i = 0; i < len; i++){
		printf("%d, ",array[i]);
	}

	printf("]\n");
}

void swap(int* a, int* b){
	int aux = *a;
	*a = *b;
	*b = aux;
}

int getMax(int *array, int len){
	int max = array[0];
	for(int i = 1; i < len; i++){
		if(max < array[i]){
			max = array[i];
		}
	}
	return max;
}
