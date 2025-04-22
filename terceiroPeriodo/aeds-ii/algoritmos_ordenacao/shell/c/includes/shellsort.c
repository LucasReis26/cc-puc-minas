#include "shellsort.h"

void shellSort(int *array, int len){
	int h = 1;

	do{h = (h * 3) + 1;}while(h < len);

	do{
		h/=3;
		for(int cor = 0; cor < h; cor++){
			insercaoPorCor(array,cor,h,len);
		}
	}while(h != 1);
}

void insercaoPorCor(int *array, int cor, int h, int len){
	for(int i = (cor + h); i < len; i+=h){
		int tmp = array[i];
		int j = i - h;
		while(j >= 0 && tmp < array[j]){
			array[j + h] = array[j];
			j -= h;
		}
		if((j + h) != i){
			array[j + h] = tmp;
		}
	}
}
