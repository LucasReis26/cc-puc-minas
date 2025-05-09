#include <iostream>
#include <string>

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

void leRenas(Rena *x){

	std::string nome;
	int peso;
	int idade;
	float altura;

	std::cin >> nome >> peso >> idade >> altura;

	*x = Rena(nome,peso,idade,altura);

}

int my_strcmp(std::string w1, std::string w2){

	int len1 = w1.length(),
		len2 = w2.length(),
		min = (len1 < len2) ? len1 : len2,
		resp = 0;

	for(int i = 0; i < min; i++){
		if(w1[i] > w2[i]){
			resp = 1;
			i = min;
		} else if( w1[i] < w2[i]){
			resp = -1;
			i = min;
		}
	}

	if(resp == 0 && len1 != len2){
		resp = (len1 < len2) ? -1 : 1;
	}

	return resp;

}

int verificaMaior(Rena *array,int i, int j){

	int resp = i;
	bool v = false;

	if(array[i].peso > array[j].peso){
		resp = i;
		v = true;
	}

	if(!v && array[i].peso != array[j].peso){
		resp = j;
		v = true;
	}

	if(!v && array[i].idade < array[j].idade){
		resp = i;
		v = true;
	}

	if(!v && array[i].idade != array[j].idade){
		resp = j;
		v = true;
	}

	if(!v && array[i].altura < array[j].altura){
		resp = i;
		v = true;
	}

	if(!v && array[i].altura != array[j].altura){
		resp = j;
		v = true;
	}

	if(!v && my_strcmp(array[i].nome, array[j].nome) < 0){
		resp = i;
		v = true;
	}

	if(!v && my_strcmp(array[i].nome, array[j].nome) != 0){
		resp = j;
		v = true;
	}

	return resp;
}

void ordenaRenas(Rena *array, int len){

	for(int i = 0; i < len; i++){

		int maior = i;

		for(int j = i + 1; j < len; j++){

			maior = verificaMaior(array,maior,j);

		}

		Rena aux = array[i];
		array[i] = array[maior];
		array[maior] = aux;
	}
}

int main(){

	int numCases;

	std::cin >> numCases;

	for(int i = 0; i < numCases; i++){

		std::cout << "CENARIO {" << i + 1 << "}" << std::endl;

		int totalRenas,
			renasTreno;

		std::cin >> totalRenas >> renasTreno;

		Rena *renas = new Rena[totalRenas];

		for(int j = 0; j < totalRenas; j++){

			leRenas(&renas[j]);
		}

		ordenaRenas(renas, totalRenas);

		for(int j = 0; j < renasTreno; j++){
			std::cout << j + 1 << " - " << renas[j].nome << std::endl;
		}


		delete[] renas;

	}

	return 0;
}
