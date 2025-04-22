all: cutils cmain cshell
	gcc main.o shellsort.o myutils.o -o exec

cmain:
	gcc -c main.c

cutils:
	gcc -c includes/myutils.c

cshell:
	gcc -c includes/shellsort.c

clear:
	rm -rf *.o;
	rm exec;
