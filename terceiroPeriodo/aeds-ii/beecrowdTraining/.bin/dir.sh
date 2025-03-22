#!/bin/bash

writePubsLt10(){
	nvim ex0$x/pubs/pub.in;
	nvim ex0$x/pubs/pub.out;
}

writePubsGe10(){
	nvim ex$x/pubs/pub.in;
	nvim ex$x/pubs/pub.out;
}

mkExFilesLt10(){
	>ex0$x/c/ex0$x.c
	>ex0$x/cpp/ex0$x.cpp
	>ex0$x/java/Ex0$x.java
}

mkExFilesGe10(){
	>ex$x/c/ex$x.c
	>ex$x/cpp/ex$x.cpp
	>ex$x/java/Ex$x.java
}

mkdir_ex(){
	if [ "$x" -lt 10 ]
	then
			mkdir -p ex0$x/pubs
			mkdir ex0$x/c
			mkdir ex0$x/cpp
			mkdir ex0$x/java
			writePubsLt10
			mkExFilesLt10
	elif [ "$x" -ge 10 ] 
	then
			mkdir -p ex$x/pubs
			mkdir ex$x/c
			mkdir ex$x/cpp
			mkdir ex$x/java
			writePubsGe10
			mkExFilesGe10
	fi
}

read -p "Digite o número da questão:" x;

mkdir_ex;


