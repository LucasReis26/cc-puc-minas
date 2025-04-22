all: cutils cinsercao cmain
	gcc myutils.o insertionsort.o main.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c includes/myutils.c

cinsercao:
	gcc -c includes/insertionsort.c

clear:
	rm *.o
	rm exec
