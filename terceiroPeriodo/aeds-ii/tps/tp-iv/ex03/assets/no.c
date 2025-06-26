#include <stdlib.h>
#include "no.h"
#include "show.h"
#include "tools.h"

NO* new_no(SHOW elemento){
	NO *resp = (NO *)calloc(1,sizeof(NO));

	resp->elemento = clone(elemento);
	resp->nivel = 1;
	resp->esq = resp->dir = NULL;

	return resp;
}

void setNivel(NO *no){
	no->nivel = 1 + max(getNivel(no->esq),getNivel(no->dir));
}

int getNivel(NO* no){
	return (no == NULL) ? 0 : no->nivel;
}
