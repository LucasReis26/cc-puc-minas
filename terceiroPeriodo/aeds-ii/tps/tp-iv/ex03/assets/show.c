#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "show.h"
#include "tools.h"

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
						a->date_added.month = 3;
						a->date_added.date = 1;
						a->date_added.year = 1900;
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
					break;
				}
		}
	}

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
