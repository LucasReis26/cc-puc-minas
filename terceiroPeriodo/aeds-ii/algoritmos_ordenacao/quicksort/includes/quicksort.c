#include "quicksort.h"
#include "myutils.h"

void quickSort(int *array, int len){
	quickSortRec(array,0,len-1);
}

void quickSortRec(int *array, int esq, int dir){
	int i = esq;
	int j = dir;
	int pivo = array[(esq + dir) / 2];
	while(i <= j){
		while(array[i] < pivo){
			i++;
		}
		while(array[j] > pivo){
			j--;
		}
		if(i <= j){
			swap(&array[i],&array[j]);
			i++;
			j--;
		}
	}
	if(esq < j){
		quickSortRec(array,  esq,  j);
	}
	if(i < dir){
		quickSortRec(array, i, dir);
	}
}
