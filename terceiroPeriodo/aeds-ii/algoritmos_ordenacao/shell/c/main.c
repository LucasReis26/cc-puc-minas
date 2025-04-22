#include "myutils.h"

int main(){

	int array[] = {10, 6, 20, 3, 7, 45, 90};

	int len = sizeof(array) / sizeof(int);

	printArray(array,len);
	
	int h = 1;

	do{h = (h * 3) + 1;}while(h < len);

	do{
		h /= 3;
		for(int cor = 0; cor < h; cor++){
			insercaoPorCor(array,cor,h, len);
		}
	}while(h != 1);


	printArray(array,len);

	return 0;
}

