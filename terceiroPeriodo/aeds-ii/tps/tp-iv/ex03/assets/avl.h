#ifndef AVL_H
#define AVL_H

#include "no.h"
#include "show.h"
#include <stdbool.h>

typedef struct AVL{
	NO* raiz;
}AVL;

AVL* new_avl();

NO* rotacionarDir(NO*);
NO* rotacionarEsq(NO*);
NO* balancear(NO*);

bool f_pesquisar(char*,NO*);
bool pesquisar(char*,AVL*);
NO* f_inserir(SHOW,NO*);
void inserir(SHOW,AVL*);


#endif
