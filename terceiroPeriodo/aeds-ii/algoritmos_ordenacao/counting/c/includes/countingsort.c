#include "countingsort.h"
#include "myutils.h"

void countingSort(int *array, int len){
	int max = getMax(array,len) + 1;

	int ordenado[len];
	int counting[max];

	for(int i = 0; i < max;counting[i] = 0, i++);
	for(int i = 0; i < len; counting[array[i]]++, i++);
	for(int i = 1; i < max; counting[i]+=counting[i - 1], i++);
	for(int i = len - 1; i >= 0; ordenado[counting[array[i]] - 1] = array[i], counting[array[i]]--, i--);
	for(int i = 0; i < len; array[i] = ordenado[i], i++);
}
