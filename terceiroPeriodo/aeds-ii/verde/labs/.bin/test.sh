#!/bin/bash

echo "Digite o número da questão que você quer testar: ";
read num;

if [ "$num" -lt 10 ]; then
	if [ -e ex0$num/ex0$num.c ]; then
		runner="ex0$num/ex0$num.c"
		gcc $runner -o ex0$num/exec;
		ex0$num/exec < ex0$num/pubs/pub.in > ex0$num/program.out;
		nvim -d ex0$num/program.out ex0$num/pubs/pub.out;
	elif [ -e ex0$num/ex0$num.java ]; then
		runner="ex0$num/Ex0$num.java"
		javac $runner;
		java ex0$num/Ex0$num < ex0$num/pubs/pub.in > ex0$num/program.out;
		nvim -d ex0$num/program.out ex0$num/pubs/pub.out;
	else
		echo "Exercício não encontrado";
	fi;
elif [ "$num" -ge 10 ]; then
	if [ -e ex$num/ex$num.c ]; then
		runner="ex$num/ex$num.c"
		gcc $runner -o ex$num/exec;
		ex$num/exec < ex$num/pubs/pub.in > ex$num/program.out;
		nvim -d ex$num/program.out ex$num/pubs/pub.out;
	elif [ -e ex$num/ex$num.java ]; then
		runner="ex$num/Ex$num.java"
		javac $runner;
		java ex$num/Ex$num < ex$num/pubs/pub.in > ex$num/program.out;
		nvim -d ex$num/program.out ex$num/pubs/pub.out;
	else
		echo "Exercício não encontrado";
	fi;
fi;


