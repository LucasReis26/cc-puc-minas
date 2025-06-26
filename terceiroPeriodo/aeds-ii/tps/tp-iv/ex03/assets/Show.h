#ifndef SHOW_H
#define SHOW_H

#include <stddef.h>
#include "Date.h"

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

SHOW clone(SHOW);
char* arrayToString(char**,size_t);
void imprimir(SHOW*);
void ler(SHOW*,char*);
void freeShow(SHOW*);

#endif
