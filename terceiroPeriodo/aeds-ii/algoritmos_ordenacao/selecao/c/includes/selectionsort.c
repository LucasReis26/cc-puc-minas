#include "selectionsort.h"
#include "myutils.h"

void selectionSort(int *array, int len){
	for(int i = 0; i < len; i++){
		int menor = i;
		for(int j = i + 1; j < len - 1; j++){
			if(array[menor] > array[j]){
				menor = j;
			}
		}
		if(menor != i){
			swap(&array[menor],&array[i]);
		}
	}
}
