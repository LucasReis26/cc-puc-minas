all: main myutils quicksort
	gcc main.o myutils.o quicksort.o -o exec

main:
	gcc -c main.c

myutils:
	gcc -c includes/myutils.c

quicksort:
	gcc -c includes/quicksort.c

clear:
	rm *.o
	rm exec

