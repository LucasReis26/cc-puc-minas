#!/bin/bash

testC_MaiorIgual10(){
	if [ -s "ex$num/c/ex$num.c" ]
	then
		program="ex$num/c/ex$num.c"
		runner="ex$num/c/exec"
		pubin="ex$num/pubs/pub.in"
		pubout="ex$num/pubs/pub.out"
		out="ex$num/program.out"

		gcc $program -o $runner		
		$runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -1"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testC_Menor10(){
	if [ -s "ex0$num/c/ex0$num.c" ]
	then
		program="ex0$num/c/ex0$num.c"
		runner="ex0$num/c/exec"
		pubin="ex0$num/pubs/pub.in"
		pubout="ex0$num/pubs/pub.out"
		out="ex0$num/program.out"

		gcc $program -o $runner		
		$runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -2"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testC(){
	if [ "$num" -lt 10 ]
	then
		testC_Menor10
	else
		testC_MaiorIgual10
	fi
}
testCppMaiorIgual10(){
	if [ -s "ex$num/cpp/ex$num.cpp" ]
	then
		program="ex$num/cpp/ex$num.cpp"
		runner="ex$num/cpp/exec"
		pubin="ex$num/pubs/pub.in"
		pubout="ex$num/pubs/pub.out"
		out="ex$num/program.out"

		g++ $program -o $runner		
		$runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -3"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testCppMenor10(){
	if [ -s "ex0$num/cpp/ex0$num.cpp" ]
	then
		program="ex0$num/cpp/ex0$num.cpp"
		runner="ex0$num/cpp/exec"
		pubin="ex0$num/pubs/pub.in"
		pubout="ex0$num/pubs/pub.out"
		out="ex0$num/program.out"

		g++ $program -o $runner		
		$runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -4"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testCpp(){
	if [ "$num" -lt 10 ]
	then
		testCppMenor10
	else
		testCppMaiorIgual10
	fi
}

testJavaMenor10(){
	if [ -s "ex0$num/java/Ex0$num.java" ]
	then
		program="ex0$num/java/Ex0$num.java"
		runner="ex0$num.java.Ex0$num"
		pubin="ex0$num/pubs/pub.in"
		pubout="ex0$num/pubs/pub.out"
		out="ex0$num/program.out"

		javac $program
		java $runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -5"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testJavaMaiorIgual10(){
	if [ -s "ex$num/java/Ex$num.java" ]
	then
		program="ex$num/java/Ex$num.java"
		runner="ex$num.java.Ex$num"
		pubin="ex$num/pubs/pub.in"
		pubout="ex$num/pubs/pub.out"
		out="ex$num/program.out"

		javac $program
		java $runner < $pubin > $out
		nvim -d $out $pubout
	else
		echo "ERROR: Arquivo vazio"
		echo "cod: -6"
		echo ""
		read -p "Pressione enter para continuar..." enter
		clear
	fi
}

testJava(){
	if [ "$num" -lt 10 ]
	then
		testJavaMenor10
	else
		testJavaMaiorIgual10
	fi
}

clear
read -p "Digite o número da questão que você quer testar: " num
echo ""
echo "Escolha a linguagem que você quer testar:"
echo " 1 - C;"
echo " 2 - Java;"
read -p "Sua escolha: " lang
clear

if [ "$lang" == 1 ]
then
	testC
elif [ "$lang" == 2 ]
then
	testJava
else
	echo "ERROR: Linguagem Inválida"
	echo "cod: -7"
fi
