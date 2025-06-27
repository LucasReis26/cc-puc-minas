#ifndef NO_H
#define NO_H

#include "show.h"

typedef struct NO{
	SHOW elemento;
	int nivel;
	struct NO* dir;
	struct NO* esq;
}NO;

NO* new_no(SHOW);
int getNivel(NO*);
void setNivel(NO*);


#endif
