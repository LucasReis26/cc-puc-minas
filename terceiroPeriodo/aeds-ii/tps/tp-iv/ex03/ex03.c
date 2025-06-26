#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "assets/show.h"
#include "assets/tools.h"
#include "assets/avl.h"

int main(){
	SHOW *shows = (SHOW *)calloc(1368,sizeof(SHOW));

	FILE *file = fopen("/tmp/disneyplus.csv", "r");

	char *line = (char *)malloc(1024*sizeof(char));
	while(fgetc(file) != '\n');

	for(int i = 0; i < 1368; i++){
		readLine(line, 1024,  file);
		ler((shows + i),line);
	}

	free(line);
	fclose(file);

	AVL* avl = new_avl();

	readLine(line,255,stdin);

	while(strcmp(line,"FIM") != 0){
		int show_id = atoi(line+1) - 1;
		inserir(shows[show_id], avl);
		readLine(line,255,stdin);
	}

	readLine(line,255,stdin);

	while(strcmp(line,"FIM") != 0){
		if(pesquisar(line, avl)) printf("SIM\n");
		else printf("NAO\n");
		readLine(line,255,stdin);
	}

	for(int i = 0; i < 1368; i++)
		freeShow(shows + i);
	free(shows);

	return 0;
}
