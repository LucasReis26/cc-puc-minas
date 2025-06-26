#ifndef DATE_H
#define DATE_H

typedef struct{
	int date;
	int month;
	int year;
}DATE;

char* integerToMonth(int);
int monthToInteger(char*);
char* dateToString(DATE);

#endif
