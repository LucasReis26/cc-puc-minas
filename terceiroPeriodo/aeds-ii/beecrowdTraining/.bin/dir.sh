#!/bin/bash

writePubsLt10(){
	nvim ex0$x/pubs/pub.in;
	nvim ex0$x/pubs/pub.out;
}

writePubsGe10(){
	nvim ex$x/pubs/pub.in;
	nvim ex$x/pubs/pub.out;
}

mkdirC(){
	if [ "$x" -lt 10 ]; then
			mkdir -p ex0$x/pubs;
			writePubsLt10;
			>ex0$x/ex0$x.c
	elif [ "$x" -ge 10 ]; then
			mkdir -p ex$x/pubs;
			writePubsGe10;
			> ex$x/ex$x.c;
	fi;
}

mkdirJ(){
	if [ "$x" -lt 10 ]; then
			mkdir -p ex0$x/pubs;
			writePubsLt10;
			> ex0$x/Ex0$x.java;
	elif [ "$x" -ge 10 ]; then
			mkdir -p ex$x/pubs;
			writePubsGe10;
			> ex$x/Ex$x.java;
	fi;
}

read -p "Digite a linguagem (c) Language ou (j)ava:" language;
read -p "Digite o número da questão:" x;

if [ "$language" == "c" ]; then
	mkdirC;
elif [ "$language" == "j" ]; then
	mkdirJ;
else
	echo "Não encontrei o tipo do exercício";
fi;



