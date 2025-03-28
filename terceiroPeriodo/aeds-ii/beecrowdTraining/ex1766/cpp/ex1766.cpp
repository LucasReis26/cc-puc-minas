#include <iostream>
#include <iomanip>

class Rena{

	public:
		std::string nome;
		int peso;
		int idade;
		float altura;

	Rena(){
		nome = "Sem Nome";
		peso = 0;
		idade = 0;
		altura = 0.0;
	}

	Rena(std::string nome, int peso, int idade, float altura){
		this->nome = nome;
		this->peso = peso;
		this->idade = idade;
		this->altura = altura;
	}
};

int main(){

	int numCases;

	std::cin >> numCases;

	for(int i = 0; i < numCases; i++){

		int totalRenas,
			renasTreno;

		std::cin >> totalRenas >> renasTreno;

		Rena *renas = new Rena[totalRenas];

		for(int j = 0; j < totalRenas; j++){

			std::string nome;
			int peso;
			int idade;
			float altura;

			std::cin >> nome >> peso >> idade >> altura;

			renas[0] = Rena(nome,peso,idade,altura);
		}

		delete[] renas;

	}

	return 0;
}
