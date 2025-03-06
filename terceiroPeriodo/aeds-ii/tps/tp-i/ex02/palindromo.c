#include <stdlib.h>
#include <stdio.h>
#include <wchar.h>
#include <locale.h>

int wslen(wchar_t *w){
	int count = 0;
	while(w[count] != L'\0')
		count++;
	return count;
}

int slen(char *w){
	int count = 0;
	while(w[count] != '\0')
		count++;
	return count;
}

int scmp(char *w1, char *w2){
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
	if(resp == min && wlen1 != wlen2){
		resp = (wlen1 < wlen2) ? -1 : 1;
	}

	return resp;
}

void removeE(char *w){
	int wlen = slen(w);
	for(int i = 0; i < wlen; i++){
		if(w[i] == '\n'){
			w[i] = '\0';
		}
	}
}

void readLine(char *w){
	fgets(w,256,stdin);
	removeE(w);
}

int ehPalindromo(wchar_t *w){
	int wlen = wslen(w),
		resp = 1;
	for(int i = 0; i < wlen/2; i++){
		if(w[i] != w[wlen - i - 1]){
			resp = 0;
			i = wlen;
		}
	}
	return resp;
}

int main(){
	setlocale(LC_ALL,"pt_BR.UTF-8");
	char *w = (char *)malloc(256*sizeof(char));
	wchar_t *nw = (wchar_t *)malloc(256*sizeof(char));
	readLine(w);
	while(scmp(w,"FIM") != 0){
		mbstowcs(nw,w,256);
		if(ehPalindromo(nw))
			printf("SIM\n");
		else
			printf("NAO\n");
		readLine(w);
	}
	free(w);
	free(nw);
	return 0;
}
