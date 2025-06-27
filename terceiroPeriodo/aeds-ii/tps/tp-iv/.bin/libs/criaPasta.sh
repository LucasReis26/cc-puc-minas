criaPasta_m_10(){

	mkdir -p "./ex0$1/pubs/"

	if [ "$2" -eq 1 ]
	then
		touch "./ex0$1/ex0$1.c"
	elif [ "$2" -eq 2 ]
	then
		touch "./ex0$1/Ex0$1.java"
	else
		echo "ERROR: Não foi possível identificar a linguagem"
	fi

	echo "Deseja incluir as pubs?"
	echo " 1 - Sim"
	echo " 2 - Não"
	read -p "Sua opção: " op

	if [ "$op" -eq 1 ]
	then

		unzip ~/Downloads/pubs.zip -d ./ex0$1/pubs/

	fi

	rm ~/Downloads/pubs.zip

	echo $'\nPasta criada com sucesso!'


	read -p $'\nPressione ENTER para sair...'

	clear
} 

criaPasta_M_10(){

	mkdir -p "./ex$1/pubs/"

	if [ "$2" -eq 1 ]
	then
		touch "./ex$1/ex$1.c"
	elif [ "$2" -eq 2 ]
	then
		touch "./ex$1/Ex$1.java"
	else
		echo "ERROR: Não foi possível identificar a linguagem"
	fi

	echo "Deseja incluir as pubs?"
	echo " 1 - Sim"
	echo " 2 - Não"
	read -p "Sua opção: " op

	if [ "$op" -eq 1 ]
	then

		unzip ~/Downloads/pubs.zip -d ./ex$1/pubs/
		rm ~/Downloads/pubs.zip

	fi

	echo $'\nPasta criada com sucesso!'

	read -p $'\nPressione ENTER para sair...' 

	clear
}
