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
		for(int j = 0; j < len - i - 1;j++){
			int atual = array[j];
			int prox = array[j + 1];

			if(prox < atual){
				swap(&array[j],&array[j + 1]);
			}
		}
	}

	printArray(array,len);

	return 0;
}
