#ifndef AVL_H
#define AVL_H

#include "no.h"
#include "show.h"
#include <stdbool.h>
#include "logStatus.h"

typedef struct AVL{
	NO* raiz;
}AVL;

AVL* new_avl();

NO* rotacionarDir(NO*);
NO* rotacionarEsq(NO*);
NO* balancear(NO*);

bool f_pesquisar(char*,NO*,LOGSTATUS*);
bool pesquisar(char*,AVL*,LOGSTATUS*);
NO* f_inserir(SHOW,NO*);
void inserir(SHOW,AVL*);


#endif
