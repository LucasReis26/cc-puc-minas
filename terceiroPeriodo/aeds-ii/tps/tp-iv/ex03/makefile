all: main tools avl no date show logstatus
	gcc ex03.o tools.o avl.o no.o show.o date.o logStatus.o -o exec;

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

logstatus:
	gcc -c ./assets/logStatus.c;

debug: gdb
	gcc ex03.o tools.o avl.o no.o show.o date.o -o exec;

gdb:
	gcc -g -c ./ex03.c
	gcc -g -c ./assets/tools.c
	gcc -g -c ./assets/date.c
	gcc -g -c ./assets/show.c
	gcc -g -c ./assets/no.c
	gcc -g -c ./assets/avl.c
	gcc -g -c ./assets/logStatus.c

