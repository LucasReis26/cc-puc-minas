#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <stdbool.h>
#include <time.h>

typedef struct{
	int date;
	int month;
	int year;
}DATE;

typedef struct{
	char *show_id;
	char *type;
	char *title;
	char *director;
	char **cast;
	size_t castLen;
	char *country;
	DATE date_added;
	int release_year;
	char *rating;
	char *duration;
	char **listed_in;
	size_t listedLen;
}SHOW;

int monthToInteger(char *w){
	int resp = 0;

	if(strcmp(w,"January") == 0) resp = 1; 
	if(strcmp(w,"February") == 0) resp = 2; 
	if(strcmp(w,"March") == 0) resp = 3; 
	if(strcmp(w,"April") == 0) resp = 4; 
	if(strcmp(w,"May") == 0) resp = 5; 
	if(strcmp(w,"June") == 0) resp = 6; 
	if(strcmp(w,"July") == 0) resp = 7; 
	if(strcmp(w,"August") == 0) resp = 8; 
	if(strcmp(w,"September") == 0) resp = 9; 
	if(strcmp(w,"October") == 0) resp = 10; 
	if(strcmp(w,"November") == 0) resp = 11; 
	if(strcmp(w,"December") == 0) resp = 12; 

	return resp;
}
char *integerToMonth(int x){
	char *resp = (char *)malloc(25 * sizeof(char));
	
	switch(x){
		case 1:
			strcpy(resp,"January");
			break;
		case 2:
			strcpy(resp,"February");
			break;
		case 3:
			strcpy(resp,"March");
			break;
		case 4:
			strcpy(resp,"April");
			break;
		case 5:
			strcpy(resp,"May");
			break;
		case 6:
			strcpy(resp,"June");
			break;
		case 7:
			strcpy(resp,"July");
			break;
		case 8:
			strcpy(resp,"August");
			break;
		case 9:
			strcpy(resp,"September");
			break;
		case 10:
			strcpy(resp,"October");
			break;
		case 11:
			strcpy(resp,"November");
			break;
		case 12:
			strcpy(resp,"December");
			break;
		default:
			printf("ERROR: Mes nao encontrado");
			break;
	}

	return resp;
}

char *itoa(int num){
	char *resp = (char *)malloc(12 * sizeof(char));

	sprintf(resp,"%d",num);

	return resp;
}

char* dateToString(DATE date){
	char *s_date = (char *)calloc(255 , sizeof(char));
	char *month = integerToMonth(date.month);
	char *day = itoa(date.date);
	char *year = itoa(date.year);

	strcat(s_date,month);
	strcat(s_date," ");
	strcat(s_date,day);
	strcat(s_date,", ");
	strcat(s_date,year);

	free(month);
	free(day);
	free(year);

	return s_date;
}

char* arrayToString(char **array,size_t len){
	char *resp = (char *)calloc(255,sizeof(char));

	for(int i = 0; i < len; i++){
		strcat(resp,array[i]);
		if(i != len -1)
			strcat(resp,", ");
	}

	return resp;
}

void imprimir(SHOW *a){
	char *s_date_added;

	bool v1 = (a->date_added.month != 0);
	bool v2 = (a->date_added.date != 0);
	bool v3 = (a->date_added.year != 0);

	if(v1 && v2 && v3){
		s_date_added = dateToString(a->date_added);
	}else{
		s_date_added = (char *)calloc(5,sizeof(char));
		strcpy(s_date_added,"NaN");
	}

	char* s_cast;
	if(a->cast != NULL){
		s_cast = arrayToString(a->cast, a->castLen);
	}else{
		s_cast = (char *)calloc(5,sizeof(char));
		strcpy(s_cast,"NaN");
	}
	
	char* s_listed_in;
	if(a->listed_in != NULL){
		s_listed_in = arrayToString(a->listed_in,a->listedLen);
	}else{
		s_listed_in = (char *)calloc(5,sizeof(char));
		strcpy(s_listed_in,"NaN");
	}

	printf("=> %s ## %s ## %s ## %s ## [%s] ## %s ## %s ## %d ## %s ## %s ## [%s] ##\n",a->show_id,a->title,a->type,a->director,s_cast,a->country,s_date_added, a->release_year, a->rating, a->duration, s_listed_in);

	free(s_date_added);
	free(s_listed_in);
	free(s_cast);
}

void ler(SHOW *a, char *line){
	int len = strlen(line);
	char *atributos[11];
	int k = 0;
	int l = 0;
	for(int i = 0; i < 11; i++){
		atributos[i] = (char *)calloc(1024,sizeof(char));
		strcpy(atributos[i],"NaN");
	}
	for(int i = 0; i < len && k < 11; i++){
		if(line[i] != ','){
			if(line[i] == '"'){
				i++;
				while(line[i] != '"'){
					atributos[k][l++] = line[i++];
				}
			}else{
				atributos[k][l++] = line[i];
			}
		}else{
			atributos[k][l] = '\0';
			l = 0;
			k++;
			while(line[i + 1] == ','){
				atributos[k][l++] = 'N';
				atributos[k][l++] = 'a';
				atributos[k][l++] = 'N';
				atributos[k][l] = '\0';
				i++;
				if(k < 11)
					k++;
				l = 0;
			}
			
		}
	}

	// printf("\nDetectado:");
	// for(int i = 0; i < 11; i++)
	// 	printf("\n %d - %s",i + 1, atributos[i]);

	for(int i = 0; i < 11; i++){
		switch(i){
			case 0:
				{
					size_t len = strlen(atributos[i]);
					a->show_id =(char *)malloc((len + 1) * sizeof(char));
					strcpy(a->show_id,atributos[i]);
					// printf("\n%s\n",a->show_id);
					break;
				}
			case 1:
				{
					size_t len = strlen(atributos[i]);
					a->type =(char *)malloc((len + 1)* sizeof(char));
					strcpy(a->type,atributos[i]);
					break;
				}
			case 2:
				{
					size_t len = strlen(atributos[i]);
					a->title =(char *)calloc((len + 1) , sizeof(char));
					strcpy(a->title,atributos[i]);
					break;
				}
			case 3:
				{
					size_t len = strlen(atributos[i]);
					a->director =(char *)malloc((len + 1) * sizeof(char));
					strcpy(a->director,atributos[i]);
					break;
				}
			case 4:
				{
					// printf("\n%s, %s\n",a->show_id, atributos[i]);
					// printf("\n%ld\n",strlen(atributos[i]));
					if(strcmp(atributos[i],"NaN") != 0 || strlen(atributos[i]) != 0){
						int quantidade = 1;
						int len = strlen(atributos[i]);

						for(int j = 0; j < len; j++)
							if(atributos[i][j] == ',')
								quantidade++;

						a->castLen = quantidade;

						a->cast = (char **)calloc(quantidade , sizeof(char*));
						for(int j = 0; j < quantidade;j++){
							*(a->cast + j) = (char *)calloc(len , sizeof(char));
						}

						for(int j = 0,k = 0,l = 0; j < len; j++){
							if(atributos[i][j] != ','){
								a->cast[k][l++] = atributos[i][j];
							}else if(atributos[i][j] == ','){
								a->cast[k++][l] = '\0';
								l = 0;
								if(atributos[i][j + 1] == ' '){
									j++;
								}
							}
						}

						size_t s_len = a->castLen;
						for(int j = 0; j < s_len - 1; j++){
							int menor = j;
							for(int k = j + 1; k < s_len; k++){
								if(strcmp(a->cast[k],a->cast[menor]) < 0){
									menor = k;
								}
							}
							char *aux = a->cast[j];
							a->cast[j] = a->cast[menor];
							a->cast[menor] = aux;
						}

					}else{
						a->castLen = 0;
						a->cast = NULL;
					}

					break;
				}
			case 5:
				{
					size_t len = strlen(atributos[i]);
					a->country =(char *)malloc((len + 1) * sizeof(char));
					strcpy(a->country,atributos[i]);
					break;
				}
			case 6:
				{
					if(strcmp(atributos[i],"NaN") != 0){
						int len = strlen(atributos[i]);
						char c_month[len];
						char c_date[len];
						char c_year[len];

						int k;
						for(int j = 0; j < len; j++){
							if(atributos[i][j] != ' '){
								c_month[j] = atributos[i][j];
							}else{
								c_month[j] = '\0';
								k = j + 1;
								j = len;
							}
						}
						for(int j = k,l = 0; j < len; j++){
							if(atributos[i][j] != ','){
								c_date[l++] = atributos[i][j];
							}else{
								c_date[l] = '\0';
								k = j + 2;
								j = len;
							}
						}
						for(int j = k,l = 0; j < len; j++){
							c_year[l++] = atributos[i][j];
							if(j == len - 1)
								c_year[l] = '\0';
						}

						a->date_added.month = monthToInteger(c_month);
						a->date_added.date = atoi(c_date);
						a->date_added.year = atoi(c_year);
					}else{
						a->date_added.month = 0;
						a->date_added.date = 0;
						a->date_added.year = 0;
					}
					break;
				}
			case 7:
				a->release_year = atoi(atributos[i]);
				break;
			case 8:
				{
					size_t len = strlen(atributos[i]);
					a->rating =(char *)malloc((len + 1) * sizeof(char));
					strcpy(a->rating,atributos[i]);
					break;
				}
			case 9:
				{
					size_t len = strlen(atributos[i]);
					a->duration =(char *)malloc((len + 1) * sizeof(char));
					strcpy(a->duration,atributos[i]);
					break;
				}
			case 10:
				{
					if(strcmp(atributos[i],"NaN") != 0){
						int quantidade = 1;
						int len = strlen(atributos[i]);

						for(int j = 0; j < len; j++)
							if(atributos[i][j] == ',')
								quantidade++;

						a->listedLen = quantidade;

						a->listed_in = (char **)malloc(quantidade * sizeof(char*));
						for(int j = 0; j < quantidade;j++){
							*(a->listed_in + j) = (char *)malloc(len * sizeof(char));
						}

						for(int j = 0,k = 0,l = 0; j < len; j++){
							if(atributos[i][j] != ','){
								a->listed_in[k][l++] = atributos[i][j];
							}else if(atributos[i][j] == ','){
								a->listed_in[k++][l] = '\0';
								l = 0;
								if(atributos[i][j + 1] == ' '){
									j++;
								}
							}
						}

					}else{
						a->listedLen = 0;
						a->listed_in = NULL;
					}
					break;
				}
		}
	}

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

void freeShow(SHOW *i){
	free(i->show_id);
	free(i->type);
	free(i->title);
	free(i->director);
	free(i->country);
	free(i->rating);
	free(i->duration);
	if(i->cast != NULL){
		for(int j = 0; j < i->castLen; j++){
			free(*(i->cast + j));
		}
		free(i->cast);
	}
	if(i->listed_in != NULL){
		for(int j = 0; j < i->listedLen; j++){
			free(*(i->listed_in + j));
		}
		free(i->listed_in);
	}
}

SHOW clone(SHOW show){
	SHOW clone = show;
	return clone;
}

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

	char *entry = (char *)malloc(255 * sizeof(char));
	SHOW *array = (SHOW *)calloc(1368,sizeof(SHOW));
	int tam_array = 0;

	scanf("%s",entry);

	while(strcmp(entry,"FIM") != 0){
		int id = atoi((entry + 1));
		*(array + tam_array++) = clone(*(shows + --id));
		scanf("%s",entry);
	}

	for(int i = 0; i < tam_array - 1; i++){
		for(int j = 0; j < tam_array - i - 1; j++){
			if(strcmp((array + j)->title,(array + j + 1)->title) > 0){
				SHOW aux = *(array + j);
				*(array + j) = *(array + j + 1);
				*(array + j + 1) = aux;
			}
		}
	}
	getchar();

	readLine(entry,255,stdin);

	int compara = 0;
	clock_t inicio = clock();
	while(strcmp(entry,"FIM") != 0){
		int esq = 0;
		int dir = tam_array - 1;
		bool found = false;
		while(!found && esq <= dir){
			int meio = (esq + dir) / 2;
			if(strcmp(entry,(array + meio)->title) == 0){
				compara++;
				found = true;
			}else if(strcmp(entry,(array + meio)->title) > 0){
				compara += 2;
				esq = meio + 1;
			}else if(strcmp(entry,(array + meio)->title) < 0){
				compara += 3;
				dir = meio - 1;
			}
		}
		if(found){
			printf("SIM\n");
		}else{
			printf("NAO\n");
		}
		readLine(entry,255,stdin);
	}
	clock_t fim = clock();

	double tempo_ms = ((double) (fim - inicio) / CLOCKS_PER_SEC) * 1000;
	
	FILE *info = fopen("./853431_binaria.txt","w");
	fprintf(info,"853431\t%.6lf\t%d",tempo_ms,compara);
	fclose(info);
	
	free(array);
	free(entry);
	for(int i = 0; i < 1368; i++)
		freeShow(shows + i);
	free(shows);

	return 0;
}
