all: main tools date show
	gcc ex03.o tools.o avl.o no.o show.o date.o -o exec;

clear:
	rm *.o;
	rm exec;

main:
	gcc -c ./ex03.c;

tools:
	gcc -c ./assets/tools.c;

date:
	gcc -c ./assets/date.c;

show:
	gcc -c ./assets/show.c;

no:
	gcc -c ./assets/no.c;

avl:
	gcc -c ./assets/avl.c;
