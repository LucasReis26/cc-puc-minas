#include <stdio.h>
#include <stdlib.h>

int ordenaVagao(int *array, int len){
	int resp = 0;
	for(int i = 0; i < len; i++){
		for(int j = 0; j < len - i - 1; j++){
			if(array[j] > array[j + 1]){
				resp++;
				int tmp = array[j + 1];
				array[j + 1] = array[j];
				array[j] = tmp;
			}
		}
	}

	return resp;
}
int main(){

	int numCases;
	scanf("%d",&numCases);

	for(int i = 0; i < numCases; i++){

		int tamTrem;
		scanf("%d",&tamTrem);

		int *trem = (int *)malloc(tamTrem * sizeof(int));

		for(int j = 0; j < tamTrem; j++){

			scanf("%d",&trem[j]);

		}

		int swapCount = ordenaVagao(trem,tamTrem);

		printf("Optimal train swapping takes %d swaps.\n",swapCount);
		free(trem);
	}
	
	return 0;
}
