#ifndef TOOLS_H
#define TOOLS_H

#include <stdio.h>
#include <stddef.h>

char* itoa(int);
void readLine(char*,int,FILE*);
int max(int,int);
char* arrayToString(char**,size_t);

#endif
