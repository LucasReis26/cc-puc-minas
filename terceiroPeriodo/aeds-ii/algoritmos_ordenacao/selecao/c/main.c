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

int main(){

	int array[] = {10, 6, 20, 3, 7, 45, 90};

	int len = sizeof(array) / sizeof(int);

	printArray(array,len);
	
	for(int i = 0; i < len - 1; i++){
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

	printArray(array,len);

	return 0;
}
