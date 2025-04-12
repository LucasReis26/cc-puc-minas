#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	int date;
	int month;
	int year;
}DATE;

typedef struct{
	char show_id[255];
	char type[255];
	char title[255];
	char director[255];
	char **cast;
	char country[255];
	DATE date_added;
	int release_year;
	char rating[255];
	char **listed_in;
}SHOW;

void imprimir(SHOW *a){
	printf("=> %s ## %s ## %s ## %s ## [%s] ## %s ## %s %d, %d ## %d ## %s ## %s ##\n",a->show_id,a->title,a->type,a->director,a->cast,a->country,a->date_added.month,a->date_added.date, a->date_added.year, a->release_year, a->rating, a->listed_in);
}

void ler(SHOW *a, char *line){
	int len = strlen(line);
	char atributos[11][255];
	for(int i = 0,k = 0, l = 0; i < len; i++){
		if(line[i] != ','){
			if(line[i] == '"'){
				i++;
				while(line[i] != '"'){
					atributos[k][l++] = line[i++];
				}
			}else{
				atributos[k][l] = line[i];
				if(line[i + 1] != ',')
					l++;
			}
		}else if(line[i] == ',' && line[i + 1] == ','){
			l = 0;
			atributos[++k][l++] = 'N';
			atributos[k][l++] = 'a';
			atributos[k][l++] = 'N';
			atributos[k][l] = '\0';
		}else if(line[i] == ',' && line[i + 1] != ','){
			atributos[k][++l] = '\0';
			l = 0;
			k++;
		}
	}
	printf("\nDetectado: ");
	for(int i = 0; i < 11; i++){
		printf("\n%d - %s",(i + 1),atributos[i]);
	}
	printf("\n");
}

void readLine(char *line, FILE *file){
	fgets(line,255,file);
	int len = strlen(line);
	if(line[len - 1] == '\n')
		line[len - 1] = '\0';
}

int main(){
	SHOW *shows = (SHOW *)malloc(sizeof(SHOW));

	FILE *file = fopen("/tmp/disneyplus.csv", "r");

	char *line = (char *)malloc(255 * sizeof(char));
	readLine(line,file);
	readLine(line,file);
	printf("\nline: %s\n",line);

	ler(shows,line);
	

	fclose(file);
	free(shows);
	free(line);

	return 0;
}
