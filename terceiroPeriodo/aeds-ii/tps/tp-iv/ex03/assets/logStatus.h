#ifndef LOG_STATUS_H
#define LOG_STATUS_H

#include <time.h>

typedef struct LOGSTATUS{
	clock_t inicio, fim;
	int comparacoes;
}LOGSTATUS;

LOGSTATUS* new_logstatus();

void iniciarContagem(LOGSTATUS*);
void terminarContagem(LOGSTATUS*);

double getTime(LOGSTATUS*);

void comparacao(LOGSTATUS*, int);

#endif
