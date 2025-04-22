#include "myutils.h"
#include "bubblesort.h"

int main(){

	int array[] = {10, 6, 20, 3, 7, 45, 90};

	int len = sizeof(array) / sizeof(int);

	printArray(array,len);
	
	bubbleSort(array,len);

	printArray(array,len);

	return 0;
}
