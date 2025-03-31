#! /bin/bash

source .bin/libs/criaPasta.sh

clear

read -p "Digite o número do exercício: " ex

echo $'\nEscolha a linguagem do seu exercício:'
echo " 1 - C"
echo " 2 - Java"
read -p "Sua escolha: " lang

if [ "$ex" -lt 10 ] && [ "$ex" -ge 0 ]
then

	criaPasta_m_10 "$ex" "$lang"

elif [ "$ex" -ge 10 ] && [ "$ex" -lt 100 ]
then

	criaPasta_M_10 "$ex" "$lang"

fi
