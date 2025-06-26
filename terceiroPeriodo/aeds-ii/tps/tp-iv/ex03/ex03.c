#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "assets/show.h"
#include "assets/tools.h"
#include "assets/avl.h"
#include "assets/logStatus.h"

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

	LOGSTATUS* ls = new_logstatus();

	iniciarContagem(ls);
	while(strcmp(line,"FIM") != 0){
		if(pesquisar(line, avl,ls)) printf("SIM\n");
		else printf("NAO\n");
		readLine(line,255,stdin);
	}
	terminarContagem(ls);

	FILE *arquivo_log = fopen("../853431_avl.txt","w");

	fprintf(arquivo_log, "%lf\t%d", getTime(ls),ls->comparacoes);

	fclose(arquivo_log);
	for(int i = 0; i < 1368; i++)
		freeShow(shows + i);
	free(shows);

	return 0;
}
