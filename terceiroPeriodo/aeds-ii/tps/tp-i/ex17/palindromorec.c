#include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#include <locale.h>

int wslen(wchar_t *w1){
	int count = 0;

	while(w1[count] != L'\0')
		count++;

	return count;
}
int slen(char w1[]){
	int count = 0;

	while(w1[count] != '\0')
		count++;

	return count;
}
int scmp(char w1[], char w2[]){
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
void removeE(char *w){
	int i = 0,
		wlen = slen(w);

	for(i; i < wlen; i++){
		if(w[i] == '\n')
			w[i] = '\0';
	}
}
void readLine(char *w){
	fgets(w,256,stdin);
	removeE(w);
}
int ehPalindromo(wchar_t *w, int esq, int dir){
	int resp = 0;

	if(esq >= dir)
		resp = 1;
	else if(w[esq] == w[dir]){
		resp = ehPalindromo(w,++esq,--dir);
	}

	return resp;

}
int main(){
	setlocale(LC_ALL,"pt_BR.UTF-8");
	char *w = (char *)malloc(256 * sizeof(char));
	char *nw = (wchar_t *)malloc(256 * sizeof(wchar_t));

	readLine(w);

	while(scmp(w,"FIM") != 0){
		mbstowcs(nw,w,256);
		int wlen = wslen(nw);
		if(ehPalindromo(nw,0,wlen - 1))
			printf("SIM\n");
		else
			printf("NAO\n");
		readLine(w);
	}

	free(w);
	free(nw);
	return 0;
}
