#include "bubblesort.h"
#include "myutils.h"

void bubbleSort(int *array, int len){
	for(int i = 0; i < len - 1; i++){
		for(int j = 0; j < len - i - 1; j++){
			int atual = array[j];
			int prox = array[j + 1];

			if(prox < atual){
				swap(&array[j],&array[j+1]);
			}
		}
	}
}
