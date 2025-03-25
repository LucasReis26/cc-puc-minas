#!/bin/bash

my_dir=""

writePubsLt10(){
	nvim "ex0$x/pubs/pub.in"
	nvim "ex0$x/pubs/pub.out"
}

writePubsGe10(){
	nvim "ex$x/pubs/pub.in"
	nvim "ex$x/pubs/pub.out"
}

mkExFilesLt10(){
	> "ex0$x/$my_dir/ex0$x.$my_dir"
}

mkExFilesGe10(){
	> "ex$x/$my_dir/ex$x.$my_dir"
}

mkdir_ex(){
	if [ "$op" -eq 1 ]
	then
		my_dir="c"
	elif [ "$op" -eq 2 ]
	then
		my_dir="java"
	fi

	if [ "$x" -lt 10 ]
	then
			mkdir -p "ex0$x/pubs"
			mkdir "ex0$x/$my_dir/"
			writePubsLt10
			mkExFilesLt10
	elif [ "$x" -ge 10 ] 
	then
			mkdir -p "ex$x/pubs"
			mkdir "ex$x/$my_dir/"
			writePubsGe10
			mkExFilesGe10
	fi
}

read -p "Digite o número da questão:" x
echo "Escolha a linguagem que você deseja fazer a questão:"
echo " 1 - C;"
echo " 2 - Java;"
read -p "Sua opção: " op

mkdir_ex

