all: cutils cselection cmain
	gcc myutils.o selectionsort.o main.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c includes/myutils.c

cselection:
	gcc -c includes/selectionsort.c

clear:
	rm *.o
	rm exec
