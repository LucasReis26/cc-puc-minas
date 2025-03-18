#!/bin/bash

echo "Digite a linguagem (c) Language ou (j)ava:";
read y;
echo "Digite o número da questão:";
read x;

if [ "$y" == "c" ]; then
	if [ "$x" -lt 10 ]; then
			mkdir -p ex0$x/pubs;
			rm ~/Downloads/pubs.zip;
			nvim ex0$x/pubs/pub.in;
			nvim ex0$x/pubs/pub.out;
			>ex0$x/ex0$x.c
	elif [ "$x" -ge 10 ]; then
			mkdir -p ex$x/pubs;
			rm ~/Downloads/pubs.zip;
			nvim ex$x/pubs/pub.in;
			nvim ex$x/pubs/pub.out;
			> ex$x/ex$x.c;
	fi;
elif [ "$y" == "j" ]; then
	if [ "$x" -lt 10 ]; then
			mkdir -p ex0$x/pubs;
			rm ~/Downloads/pubs.zip;
			nvim ex0$x/pubs/pub.in;
			nvim ex0$x/pubs/pub.out;
			> ex0$x/Ex0$x.java;
	elif [ "$x" -ge 10 ]; then
			mkdir -p ex$x/pubs;
			rm ~/Downloads/pubs.zip;
			nvim ex$x/pubs/pub.in;
			nvim ex$x/pubs/pub.out;
			> ex$x/Ex$x.java;
	fi;
else
	echo "Não encontrei o tipo do exercício";
fi;



