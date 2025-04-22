#include "myutils.h"
#include <stdio.h>

void swap(int *a, int *b){
	int aux = *a;
	*a = *b;
	*b = aux;
}

void printArray(int *array, int len){
	printf("\n[ ");
	for(int i = 0; i < len; i++){
		printf("%d, ",array[i]);
	}
	printf("]\n");
}

void insercaoPorCor(int *array, int cor,int h, int len){
	for(int i = (h + cor); i < len; i+=h){
		int tmp = array[i];
		int j = i - h;
		while(j >= 0 && tmp < array[j]){
			array[j + h] = array[j];
			j -= h;
		}
		array[j + h] = tmp;
	}
}
