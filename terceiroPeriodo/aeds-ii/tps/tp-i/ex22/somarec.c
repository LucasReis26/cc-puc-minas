#include <stdio.h>
#include <stdlib.h>

//Função pra calcular o tamanho da string;
int slen(char *w){
	int count = 0;
	while(w[count] != '\0')
		count++;
	return count;
}
//Função pra comparar duas Strings (w1 < w2 = -1 || w1 > w2 = 1 || w1 == w2 = 0)
int scmp(char *w1, char *w2){
	int wlen1 = slen(w1),
		wlen2 = slen(w2),
		min = (wlen1 < wlen2) ? wlen1 : wlen2,
		resp = 0;

	for(int i = 0; i < min; i++){
		if(w1[i] < w2[i]){
			resp = -1;
			i = min;
		}else if(w1[i] > w2[i]){
			resp = 1;
			i = min;
		}
	}
	if(resp == 0 && wlen1 != wlen2){
		resp = (wlen1 < wlen2) ? -1 : 1;
	}

	return resp;
}
//Função pra verificar se a string é um número;
int isNumber(char *w){
	int resp = 0,
		wlen = slen(w);

	for(int i = 0; i < wlen; i++){
		if(w[i] >= '0' && w[i] <= '9'){
			resp = 1;
		}else{
			resp = 0;
			i = wlen;
		}
	}

	return resp;
}
// Função pra fazer potenciação;
int potencializa(int n1, int n2){
	int pot = 1,
		num = n1;

	if(n2 == 0)
		return 1;
	else
		for(pot; pot < n2; pot++){
			n1 *= num;
		}
	return n1;
}
//Função pra converter char pra número;
int charToNumber(char a){
	int number = ((int) a) - 48;
	return number;
}
// Função pra converter uma String pra número;
int stringToNumber(char *w){
	int resp = 0,
		wlen = slen(w);

	for(int i = wlen - 1, pot = 0; i >= 0; i--, pot++){
		if(i == wlen - 1){
			resp += charToNumber(w[i]);
		}
		else{
			resp += charToNumber(w[i]) * potencializa(10,pot);
		}
	}

	return resp;
}
//Função para ler a linha e remover o \n;
void readLine(char *w){
	fgets(w,256,stdin);
	int wlen = slen(w);
	for(int i = 0; i < wlen; i++){
		if(w[i] == '\n')
			w[i] = '\0';
	}
}
//Função recursiva para somar digitos;
int somaDigitos(int num){
	int resp = 0;
	if(num < 10)
		resp = num;
	else
		resp = (num % 10) + somaDigitos(num/10);
	return resp;
}
int main(){
	char *w = (char *)malloc(265*sizeof(char));

	readLine(w);
	while(scmp(w,"FIM") != 0){
		if(isNumber(w)){
			int num = stringToNumber(w);
			printf("%d\n",somaDigitos(num));
		}else{
			printf("Não é um número\n");
			free(w);
			return 1;
		}
		readLine(w);
	}
		

	free(w);
	return 0;
}
