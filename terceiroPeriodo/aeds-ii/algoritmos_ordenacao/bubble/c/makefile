all: cutils cbubble cmain
	gcc myutils.o bubblesort.o main.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c myutils.c

cbubble:
	gcc -c bubblesort.c

clear:
	rm *.o
	rm exec
