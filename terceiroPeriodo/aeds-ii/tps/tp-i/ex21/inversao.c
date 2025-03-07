#include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#include <locale.h>

int slen(char *w){
	int count = 0;
	while(w[count] != L'\0')
		count++;
	return count;
}
void removeE(char *w){
	int wlen = slen(w);
	for(int i = 0; i < wlen; i++){
		if(w[i] == '\n')
			w[i] = '\0';
	}
}
void readLine(char *w){
	fgets(w,256,stdin);
	removeE(w);
}

void invertString(wchar_t *w,int i,int len){
	if(i < len/2){
		wchar_t tmp = w[i];
		w[i] = w[len - i - 1];
		w[len - i - 1] = tmp; 
		invertString(w,i + 1,len);
	}	
}
int wstrcmp(char *w1, char *w2){
	int wlen1 = slen(w1),
		wlen2 = slen(w2),
		min = (wlen1 < wlen2) ? wlen1 : wlen2,
		resp = 0;

	for(int i = 0; i < min; i++){
		if(w1[i] < w2[i]){
			resp = -1;
			i = min;
		}else if(w1[i] > w2[i]){
			resp = 1;
			i = min;
		}
	}
	if(resp == 0 && wlen1 != wlen2){
		resp = (wlen1 < wlen2) ? -1 : 1;
	}

	return resp;
}
int main(){
	setlocale(LC_ALL,"en_US.UTF-8");
	char *w = (char *)malloc(256*sizeof(char));
	wchar_t *newString = (wchar_t *)malloc(256*sizeof(wchar_t));

	readLine(w);
	while(wstrcmp(w,"FIM") != 0){
		mbstowcs(newString,w,256);
		int wlen = wcslen(newString);
		invertString(newString,0,wlen);
		wprintf(L"%ls\n",newString);
		readLine(w);
	}

	free(w);
	free(newString);
	
	return 0;
}
