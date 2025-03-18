#!/bin/bash

echo "Digite a linguagem (c) Language ou (j)ava:";
read y;
echo "Digite o número da questão:";
read x;

if [ "$y" == "c" ]; then
	if [ "$x" -lt 10 ]; then
		if [ -e ~/Downloads/pubs.zip ]; then
			mkdir -p ex0$x/pubs;
			unzip ~/Downloads/pubs.zip -d ex0$x/pubs/;
			rm ~/Downloads/pubs.zip;
			> ex0$x/ex0$x.c;
		else
			echo "Baixe o pubs primeiro";
		fi;
	elif [ "$x" -ge 10 ]; then
		if [ -e ~/Downloads/pubs.zip ]; then
			mkdir -p ex$x/pubs;
			unzip ~/Downloads/pubs.zip -d ex$x/pubs/;
			rm ~/Downloads/pubs.zip;
			> ex$x/ex$x.c;
		else
			echo "Baixe o pubs primeiro";
		fi;
	fi;
elif [ "$y" == "j" ]; then
	if [ "$x" -lt 10 ]; then
		if [ -e ~/Downloads/pubs.zip ]; then
			mkdir -p ex0$x/pubs;
			unzip ~/Downloads/pubs.zip -d ex0$x/pubs/;
			rm ~/Downloads/pubs.zip;
			> ex0$x/Ex0$x.java;
		else
			echo "Baixe o pubs primeiro";
		fi;
	elif [ "$x" -ge 10 ]; then
		if [ -e ~/Downloads/pubs.zip ]; then
			mkdir -p ex$x/pubs;
			unzip ~/Downloads/pubs.zip -d ex$x/pubs/;
			rm ~/Downloads/pubs.zip;
			> ex$x/Ex$x.java;
		else
			echo "Baixe o pubs primeiro";
		fi;
	fi;
else
	echo "Não encontrei o tipo do exercício";
fi;



