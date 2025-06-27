#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "avl.h"
#include "logStatus.h"
#include "no.h"

AVL* new_avl(){
	AVL* resp = (AVL*)calloc(1,sizeof(AVL));

	resp->raiz = NULL;

	return resp;
}

bool pesquisar(char *x,AVL *avl, LOGSTATUS *ls){
	printf("raiz ");
	return f_pesquisar(x,avl->raiz,ls);
}

bool f_pesquisar(char *x, NO *i, LOGSTATUS *ls){
	bool resp;

	if(i == NULL){
		comparacao(ls, 1);
		resp = false;
	}else if(strcmp(x,i->elemento.title) == 0){
		comparacao(ls, 2);
		resp = true;
	}else if(strcmp(x,i->elemento.title) < 0){
		comparacao(ls, 3);
		printf("esq ");
		resp = f_pesquisar(x,i->esq,ls);
	}else{
		comparacao(ls, 4);
		printf("dir ");
		resp = f_pesquisar(x,i->dir,ls);
	}

	return resp;
}

void inserir(SHOW x,AVL *avl){
	avl->raiz = f_inserir(x,avl->raiz);
}

NO* f_inserir(SHOW x, NO* i){
	if(i == NULL){
		i = new_no(x);
	}else if(strcmp(x.title,i->elemento.title) < 0){
		i->esq = f_inserir(x, i->esq);
	}else if(strcmp(x.title, i->elemento.title) > 0){
		i->dir = f_inserir(x, i->dir);
	}

	return balancear(i);
}

NO* balancear(NO* no){
	if (no != NULL) {
		int fator = getNivel(no->dir) - getNivel(no->esq);
		if (abs(fator) <= 1) {
			setNivel(no);
		} else if (fator == 2) {
			int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);
			if (fatorFilhoDir == -1) {
				no->dir = rotacionarDir(no->dir);
			}
			no = rotacionarEsq(no);
		} else if (fator == -2) {
			int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);
			if (fatorFilhoEsq == 1) {
				no->esq = rotacionarEsq(no->esq);
			}
			no = rotacionarDir(no);
		}
	}
	return no;
}

NO* rotacionarDir(NO* no) {
	NO* noEsq = no->esq;
	NO* noEsqDir = noEsq->dir;

	noEsq->dir = no;
	no->esq = noEsqDir;
	setNivel(no); 
	setNivel(noEsq);

	return noEsq;
}
NO* rotacionarEsq(NO* no) {
	NO* noDir = no->dir;
	NO* noDirEsq = noDir->esq;

	noDir->esq = no;
	no->dir = noDirEsq;

	setNivel(no);
	setNivel(noDir);

	return noDir;
}
