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
	
	for(int i = 1; i < len; i++){
		int tmp = array[i];
		int j = i - 1;
		while(j >= 0 && tmp < array[j]){
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = tmp;
	}

	printArray(array,len);

	return 0;
}
