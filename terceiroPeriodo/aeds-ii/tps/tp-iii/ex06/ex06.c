#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <stdbool.h>
#include <err.h>

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


SHOW clone(SHOW show){
	SHOW clone;

	clone.show_id = (char *)calloc(strlen(show.show_id) + 1,sizeof(char));
	strcpy(clone.show_id,show.show_id);

	clone.type = (char *)calloc(strlen(show.type) + 1,sizeof(char));
	strcpy(clone.type,show.type);

	clone.title = (char *)calloc(strlen(show.title) + 1,sizeof(char));
	strcpy(clone.title,show.title);

	clone.director = (char *)calloc(strlen(show.director) + 1,sizeof(char));
	strcpy(clone.director,show.director);

	clone.castLen = show.castLen;

	if(clone.castLen > 0){
		clone.cast = (char **)calloc(clone.castLen, sizeof(char *));
		for(int i = 0; i < clone.castLen; i++){
			clone.cast[i] = (char *)calloc(strlen(show.cast[i]) + 1, sizeof(char));
			strcpy(clone.cast[i],show.cast[i]);
		}
	}else{
		clone.cast = NULL;
	}

	clone.country = (char *)calloc(strlen(show.country) + 1,sizeof(char));
	strcpy(clone.country,show.country);

	clone.date_added = show.date_added;

	clone.release_year = show.release_year;

	clone.rating = (char *)calloc(strlen(show.rating) + 1,sizeof(char));
	strcpy(clone.rating,show.rating);

	clone.duration = (char *)calloc(strlen(show.duration) + 1,sizeof(char));
	strcpy(clone.duration,show.duration);

	clone.listedLen = show.listedLen;

	if(clone.listedLen > 0){
		clone.listed_in = (char **)calloc(clone.listedLen, sizeof(char *));
		for(int i = 0; i < clone.listedLen; i++){
			clone.listed_in[i] = (char *)calloc(strlen(show.listed_in[i]) + 1, sizeof(char));
			strcpy(clone.listed_in[i],show.listed_in[i]);
		}
	}else{
		clone.listed_in = NULL;
	}

	return clone;
}

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
		case 1: strcpy(resp,"January"); break;
		case 2: strcpy(resp,"February"); break;
		case 3: strcpy(resp,"March"); break;
		case 4: strcpy(resp,"April"); break;
		case 5: strcpy(resp,"May"); break;
		case 6: strcpy(resp,"June"); break;
		case 7: strcpy(resp,"July"); break;
		case 8: strcpy(resp,"August"); break;
		case 9: strcpy(resp,"September"); break;
		case 10: strcpy(resp,"October"); break;
		case 11: strcpy(resp,"November"); break;
		case 12: strcpy(resp,"December"); break;
		default: printf("ERROR: Mes nao encontrado"); break;
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

char** splitAtributos(char* line){
	int len = strlen(line);
	char **atributos = (char **)malloc(11 * sizeof(char *));
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
	return atributos;
}

void setShowId(SHOW *a,char *atributo){
	size_t len = strlen(atributo);
	a->show_id =(char *)malloc((len + 1) * sizeof(char));
	strcpy(a->show_id,atributo);
}

void setType(SHOW *a,char *atributo){
	size_t len = strlen(atributo);
	a->type =(char *)malloc((len + 1)* sizeof(char));
	strcpy(a->type,atributo);
}

void setTitle(SHOW *a,char *atributo){
	size_t len = strlen(atributo);
	a->title =(char *)calloc((len + 1) , sizeof(char));
	strcpy(a->title,atributo);
}

void setDirector(SHOW *a,char *atributo){
	size_t len = strlen(atributo);
	a->director =(char *)malloc((len + 1) * sizeof(char));
	strcpy(a->director,atributo);
}

void setCast(SHOW *a, char *atributo){
	if(strcmp(atributo,"NaN") != 0 || strlen(atributo) != 0){
		int quantidade = 1;
		int len = strlen(atributo);

		for(int j = 0; j < len; j++)
			if(atributo[j] == ',')
				quantidade++;

		a->castLen = quantidade;

		a->cast = (char **)calloc(quantidade , sizeof(char*));
		for(int j = 0; j < quantidade;j++){
			*(a->cast + j) = (char *)calloc(len , sizeof(char));
		}

		for(int j = 0,k = 0,l = 0; j < len; j++){
			if(atributo[j] != ','){
				a->cast[k][l++] = atributo[j];
			}else if(atributo[j] == ','){
				a->cast[k++][l] = '\0';
				l = 0;
				if(atributo[j + 1] == ' '){
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
}

void setCountry(SHOW *a, char *atributo){
	size_t len = strlen(atributo);
	a->country =(char *)malloc((len + 1) * sizeof(char));
	strcpy(a->country,atributo);
}

void setDate(SHOW *a, char *atributo){
	if(strcmp(atributo,"NaN") != 0){
		int len = strlen(atributo);
		char c_month[len];
		char c_date[len];
		char c_year[len];

		int k;
		for(int j = 0; j < len; j++){
			if(atributo[j] != ' '){
				c_month[j] = atributo[j];
			}else{
				c_month[j] = '\0';
				k = j + 1;
				j = len;
			}
		}
		for(int j = k,l = 0; j < len; j++){
			if(atributo[j] != ','){
				c_date[l++] = atributo[j];
			}else{
				c_date[l] = '\0';
				k = j + 2;
				j = len;
			}
		}
		for(int j = k,l = 0; j < len; j++){
			c_year[l++] = atributo[j];
			if(j == len - 1)
				c_year[l] = '\0';
		}

		a->date_added.month = monthToInteger(c_month);
		a->date_added.date = atoi(c_date);
		a->date_added.year = atoi(c_year);
	}else{
		a->date_added.month = 3;
		a->date_added.date = 1;
		a->date_added.year = 1900;
	}
}

void setReleaseYear(SHOW *a, char *atributo){
	a->release_year = atoi(atributo);
}

void setRating(SHOW *a, char *atributo){
	size_t len = strlen(atributo);
	a->rating =(char *)malloc((len + 1) * sizeof(char));
	strcpy(a->rating,atributo);

}

void setDuration(SHOW *a, char *atributo){

	size_t len = strlen(atributo);
	a->duration =(char *)malloc((len + 1) * sizeof(char));
	strcpy(a->duration,atributo);
}

void setListedIn(SHOW *a, char *atributo){
	if(strcmp(atributo,"NaN") != 0){
		int quantidade = 1;
		int len = strlen(atributo);

		for(int j = 0; j < len; j++)
			if(atributo[j] == ',')
				quantidade++;

		a->listedLen = quantidade;

		a->listed_in = (char **)malloc(quantidade * sizeof(char*));
		for(int j = 0; j < quantidade;j++){
			*(a->listed_in + j) = (char *)malloc(len * sizeof(char));
		}

		for(int j = 0,k = 0,l = 0; j < len; j++){
			if(atributo[j] != ','){
				a->listed_in[k][l++] = atributo[j];
			}else if(atributo[j] == ','){
				a->listed_in[k++][l] = '\0';
				l = 0;
				if(atributo[j + 1] == ' '){
					j++;
				}
			}
		}

		size_t s_len = a->listedLen;
		for(int j = 0; j < s_len - 1; j++){
			int menor = j;
			for(int k = j + 1; k < s_len; k++){
				if(strcmp(a->listed_in[k],a->listed_in[menor]) < 0){
					menor = k;
				}
			}
			char *aux = a->listed_in[j];
			a->listed_in[j] = a->listed_in[menor];
			a->listed_in[menor] = aux;
		}

	}else{
		a->listedLen = 0;
		a->listed_in = NULL;
	}
}

void ler(SHOW *a, char *line){

	char **atributos = splitAtributos(line);

	setShowId(a, atributos[0]);
	setType(a, atributos[1]);
	setTitle(a, atributos[2]);
	setDirector(a,atributos[3]);
	setCast(a,atributos[4]);
	setCountry(a,atributos[5]);
	setDate(a, atributos[6]);
	setReleaseYear(a, atributos[7]);
	setRating(a,atributos[8]);
	setDuration(a,atributos[9]);
	setListedIn(a, atributos[10]);
	
	for(int i = 0; i < 11; i++){
		free(atributos[i]);
	}
	free(atributos);
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

typedef struct CELULA{
	SHOW *elemento;
	struct CELULA *prox;
}CELULA;

CELULA* new_celula(){
	CELULA *tmp = (CELULA *)malloc(sizeof(CELULA));
	tmp->elemento = (SHOW *)malloc(sizeof(SHOW));
	tmp->prox = NULL;
	return tmp;
}

CELULA* new_celula_e(SHOW show){
	CELULA *tmp = (CELULA *)malloc(sizeof(CELULA));
	tmp->elemento = (SHOW *)malloc(sizeof(SHOW));
	*(tmp->elemento) = clone(show);
	tmp->prox = NULL;
	return tmp;
}

typedef struct{
	CELULA *primeiro;
	CELULA *ultimo;
}PILHA;

PILHA* new_pilha(){
	PILHA *tmp = (PILHA *)malloc(sizeof(PILHA));
	tmp->primeiro = new_celula();
	tmp->ultimo = tmp->primeiro;
	return tmp;
}

int tamanho(PILHA *pilha){
	int tam = 0;
	CELULA *i;
	for(i = pilha->primeiro; i != pilha->ultimo; i = i->prox, tam++);
	return tam;
}

void inserir(PILHA *pilha, int pos, SHOW show){

}


SHOW remover(PILHA *pilha, int pos){

}

void mostrarRestante(PILHA *pilha){
	CELULA *i;
	for(i = pilha->primeiro->prox;i != NULL; i = i->prox){
		imprimir(i->elemento);
	}
}

void leArquivo(SHOW*);
void preenchePilhaInicialmente(PILHA*,SHOW*);
int getShowId();
int getPosition();
void executaOperacao(char*, PILHA*, SHOW*);


int main(){
	SHOW *shows = (SHOW *)calloc(1368,sizeof(SHOW));

	leArquivo(shows);
	
	PILHA *pilha_shows = new_pilha();

	preenchePilhaInicialmente(pilha_shows,shows);
	
	int quantidadeOperacoes;

	scanf("%d",&quantidadeOperacoes);
	getchar();

	for(int i = 0; i < quantidadeOperacoes; i++){
		char *op = (char *)malloc(255 * sizeof(char));

		scanf("%s",op);
		getchar();

		executaOperacao(op,pilha_shows,shows);

		free(op);
	}

	mostrarRestante(pilha_shows);

	for(int i = 0; i < 1368; i++)
		freeShow(shows + i);
	free(shows);

	return 0;
}

void leArquivo(SHOW *shows){
	FILE *file = fopen("/tmp/disneyplus.csv", "r");

	char *line = (char *)malloc(1024*sizeof(char));

	while(fgetc(file) != '\n');

	for(int i = 0; i < 1368; i++){
		readLine(line, 1024,  file);

		ler((shows + i),line);

	}

	free(line);
	fclose(file);
}

void preenchePilhaInicialmente(PILHA *pilha,SHOW *shows){
	char *entry = (char *)malloc(255 * sizeof(char));
	scanf("%s",entry);

	while(strcmp(entry,"FIM") != 0){
		int id = atoi((entry + 1));
		inserirFim(pilha,  *(shows + (--id)));
		scanf("%s",entry);
	}
}

int getShowId(){
	char *id = (char *)malloc(255 * sizeof(char));

	scanf("%s",id);
	getchar();

	int resp = atoi(id + 1);

	free(id);

	return resp;
}

int getPosition(){
	int resp;
	scanf("%d",&resp);
	getchar();
	return resp;
}

void executaOperacao(char *op, PILHA *pilha_shows, SHOW *shows){
	if(strcmp(op,"II") == 0){

		int id = getShowId();
		inserirInicio(pilha_shows,shows[--id]);

	} else if(strcmp(op,"IF") == 0){

		int id = getShowId();
		inserirFim(pilha_shows,shows[--id]);

	} else if(strcmp(op,"I*") == 0){

		int pos = getPosition();
		int id = getShowId();
		inserir(pilha_shows,pos,shows[--id]);

	}else if(strcmp(op,"RI") == 0){

		SHOW getShow = removerInicio(pilha_shows);
		printf("(R) %s\n",getShow.title);

	}else if(strcmp(op,"RF") == 0){

		SHOW getShow = removerFim(pilha_shows);
		printf("(R) %s\n",getShow.title);

	} else if(strcmp(op,"R*") == 0){

		int pos = getPosition();
		SHOW getShow = remover(pilha_shows, pos);
		printf("(R) %s\n",getShow.title);
	}
}
