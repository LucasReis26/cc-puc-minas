#include "insertionsort.h"

void insertionSort(int *array, int len){
	for(int i = 1; i < len; i++){
		int tmp = array[i];
		int j = i - 1;
		while(i >= 0 && tmp < array[j]){
			array[j + 1] = array[j];
			j--;
		}
		if((j + 1) != i){
			array[j + 1] = tmp;
		}
	}
}
