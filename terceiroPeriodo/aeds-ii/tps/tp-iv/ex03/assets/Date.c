#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "Date.h"
#include "Tools.h"

int monthToInteger(char *w){
	int resp = 0;

	if(strcmp(w,"January") == 0) resp = 1; 
	if(strcmp(w,"February") == 0) resp = 2; 
	if(strcmp(w,"March") == 0) resp = 3; 
	if(strcmp(w,"April") == 0) resp = 4; 
	if(strcmp(w,"May") == 0) resp = 5; 
	if(strcmp(w,"June") == 0) resp = 6; 
	if(strcmp(w,"July") == 0) resp = 7; 
	if(strcmp(w,"August") == 0) resp = 8; 
	if(strcmp(w,"September") == 0) resp = 9; 
	if(strcmp(w,"October") == 0) resp = 10; 
	if(strcmp(w,"November") == 0) resp = 11; 
	if(strcmp(w,"December") == 0) resp = 12; 

	return resp;
}

char *integerToMonth(int x){
	char *resp = (char *)malloc(25 * sizeof(char));
	
	switch(x){
		case 1:
			strcpy(resp,"January");
			break;
		case 2:
			strcpy(resp,"February");
			break;
		case 3:
			strcpy(resp,"March");
			break;
		case 4:
			strcpy(resp,"April");
			break;
		case 5:
			strcpy(resp,"May");
			break;
		case 6:
			strcpy(resp,"June");
			break;
		case 7:
			strcpy(resp,"July");
			break;
		case 8:
			strcpy(resp,"August");
			break;
		case 9:
			strcpy(resp,"September");
			break;
		case 10:
			strcpy(resp,"October");
			break;
		case 11:
			strcpy(resp,"November");
			break;
		case 12:
			strcpy(resp,"December");
			break;
		default:
			printf("ERROR: Mes nao encontrado");
			break;
	}

	return resp;
}
char* dateToString(DATE date){
	char *s_date = (char *)calloc(255 , sizeof(char));
	char *month = integerToMonth(date.month);
	char *day = itoa(date.date);
	char *year = itoa(date.year);

	strcat(s_date,month);
	strcat(s_date," ");
	strcat(s_date,day);
	strcat(s_date,", ");
	strcat(s_date,year);

	free(month);
	free(day);
	free(year);

	return s_date;
}
