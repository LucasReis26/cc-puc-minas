#include <stdio.h>
#include <stdlib.h>
#include "assets/show.h"
#include "assets/tools.h"

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


	for(int i = 0; i < 1368; i++)
		freeShow(shows + i);
	free(shows);

	return 0;
}
