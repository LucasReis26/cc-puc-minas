#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "tools.h"

char *itoa(int num){
	char *resp = (char *)malloc(12 * sizeof(char));

	sprintf(resp,"%d",num);

	return resp;
}

void readLine(char *line,int maxsize, FILE *file){
	if (file == NULL) {
		fprintf(stderr, "Erro: ponteiro de arquivo NULL passado para readLine().\n");
		exit(1);
	}

	if (fgets(line, maxsize, file) == NULL) {
		fprintf(stderr, "Erro ao ler linha do arquivo ou fim do arquivo atingido.\n");
		exit(1);
	}
	size_t len = strlen(line);
	if(line[len - 1] == '\n')
		line[len - 1] = '\0';
}

int max(int a, int b){
	return (a > b) ? a : b;
}
