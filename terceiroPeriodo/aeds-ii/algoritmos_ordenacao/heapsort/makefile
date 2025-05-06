all: cutils cheap cmain
	gcc main.o myutils.o heapsort.o -o exec

cutils:
	gcc -c utils/myutils.c

cheap:
	gcc -c utils/heapsort.c

cmain:
	gcc -c main.c

clear:
	rm exec *.o
