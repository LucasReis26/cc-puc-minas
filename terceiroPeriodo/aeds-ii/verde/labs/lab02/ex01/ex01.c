// Calcular o tamanho das duas strings e após isso iremos alocar memória pra um novo vetor
// criar um método pra organizar as strings na nova string, lembrando de tratar questões de tamanho de string (uma string pode ser maior que a outra) e as strings devem alternar entre si;
// printar na tela o resultado

#include <stdio.h>
#include <stdlib.h>

void combinador(char *s1, char *s2, char *s3, int len1, int len2, int len3){
	for(int i = 0, j = 0, l = 0; i < len3; i++){
		if(j < len1 && l < len2){
			if(i % 2 == 0){
				s3[i] = s1[j];
				j++;
			} else {
				s3[i] = s2[l];
				l++;
			}
		} else if (j < len1){
			s3[i] = s1[j];
			j++;
		} else if (l < len2){
			s3[i] = s2[l];
			l++;
		}
	}
}

int my_strlen(char *w){
	int count = 0;

	while(w[count] != '\0')
		count++;

	return count;
}

int main(){

	char *s1 = (char *)malloc(255*sizeof(char));
	char *s2 = (char *)malloc(255*sizeof(char));
	
	while(scanf("%s %s",s1,s2) == 2){
		int len1 = my_strlen(s1),
			len2 = my_strlen(s2),
			len3 = len1 + len2;

		char *s3 = (char *)malloc(len3*sizeof(char));

		combinador(s1,s2,s3,len1,len2,len3);

		printf("%s\n",s3);

		free(s3);
	}

	free(s1);
	free(s2);

	return 0;
}
