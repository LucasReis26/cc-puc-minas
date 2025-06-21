testaPrograma_m_10(){

	if [ -e "ex0$1/ex0$1.c" ]
	then

		gcc "ex0$1/ex0$1.c" -o "ex0$1/exec"
		"./ex0$1/exec" < "ex0$1/pubs/pub.in" > "./ex0$1/program.out"
		nvim -d "./ex0$1/program.out" "./ex0$1/pubs/pub.out"

	elif [ -e "ex0$1/Ex0$1.java" ]
	then

		javac "ex0$1/Ex0$1.java"
		java "ex0$1.Ex0$1" < "ex0$1/pubs/pub.in" > "./ex0$1/program.out"
		nvim -d "./ex0$1/program.out" "./ex0$1/pubs/pub.out"

	else

		echo $'\nERROR: Não há exercícios!'

		read -p $'\nPressione ENTER para continuar...'

		clear

	fi
}
testaPrograma_M_10(){

	if [ -e "ex$1/ex$1.c" ]
	then

		gcc "ex$1/ex$1.c" -o "ex$1/exec"
		"./ex$1/exec" < "ex$1/pubs/pub.in" > "./ex$1/program.out"
		nvim -d "./ex$1/program.out" "./ex$1/pubs/pub.out"

	elif [ -e "ex$1/Ex$1.java" ]
	then

		javac "ex$1/Ex$1.java"
		java "ex$1.Ex$1" < "ex$1/pubs/pub.in" > "./ex$1/program.out"
		nvim -d "./ex$1/program.out" "./ex$1/pubs/pub.out"

	else

		echo $'\nERROR: Não há exercícios!'

		read -p $'\nPressione ENTER para continuar...'

		clear

	fi

}
