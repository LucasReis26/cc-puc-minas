all: cutils cbubble cmain
	gcc myutils.o bubblesort.o main.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c includes/myutils.c

cbubble:
	gcc -c includes/bubblesort.c

clear:
	rm *.o
	rm exec
