#include <stdlib.h>
#include <time.h>
#include "logStatus.h"

LOGSTATUS* new_logstatus(){
	LOGSTATUS* resp = (LOGSTATUS*)calloc(1,sizeof(LOGSTATUS));

	resp->comparacoes = 0;
	resp->inicio = resp->fim = 0;

	return resp;
}

void iniciarContagem(LOGSTATUS *ls){
	ls->inicio = clock();
}
void terminarContagem(LOGSTATUS *ls){
	ls->fim = clock();
}

void comparacao(LOGSTATUS *ls,int i){
	ls->comparacoes += i;
}

double getTime(LOGSTATUS *ls){
	double resp = ((double) (ls->fim - ls->inicio) / CLOCKS_PER_SEC) * 1000.0;
	return resp;
}
