#! /bin/bash

clear

source ./libs/testaPrograma.sh

read -p "Digite o número do exercício que você quer testar: " ex

if [ "$ex" -gt 0 ] && [ "$ex" -lt 10 ] 
then

	testaPrograma_m_10 "$ex"

elif [ "$ex" -ge 10 ] && [ "$ex" -lt 100 ]
then

	testaPrograma_M_10 "$ex"

else

	echo $'\nERROR: O programa não existe!\n'

	read -p "Pressione ENTER para continuar..." enter

	clear

fi

