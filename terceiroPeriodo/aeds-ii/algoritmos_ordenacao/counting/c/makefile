all: cutils ccounting cmain
	gcc myutils.o countingsort.o main.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c includes/myutils.c

ccounting:
	gcc -c includes/countingsort.c

clear:
	rm *.o
	rm exec
