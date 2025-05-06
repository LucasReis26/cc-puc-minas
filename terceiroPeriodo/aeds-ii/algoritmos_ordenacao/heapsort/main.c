#include "utils/myutils.h"
#include "utils/heapsort.h"
#include <stdlib.h>
int main(){

	int *array = (int *)malloc(7 * sizeof(int));

	array[0] = 10;
	array[1] = 6;
	array[2] = 20;
	array[3] = 3;
	array[4] = 7;
	array[5] = 45;
	array[6] = 90;

	int len = 7;

	printArray(array,len);
	
	heapsort(array,len);

	printArray(array,len);

	return 0;
}
