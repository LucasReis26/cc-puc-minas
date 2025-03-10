#include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#include <locale.h>

int wslen(wchar_t *w){
	int count = 0;
	while(w[count] != L'\0')
		count++;
	return count;
}
void readLine(wchar_t *w){
	fgetws(w,256,stdin);
	int len = wslen(w);
	for(int i = 0; i < len; i++){
		if(w[i] == L'\n')
			w[i] = L'\0';
	}
}
void convertToInt(int *array, int len, wchar_t *w){
	for(int i = 0; i < len; i++){
		array[i] = (int) w[i];
	}
}
void convertToWchar(wchar_t *array, int len, int *w){
	for(int i = 0; i < len; i++){
		array[i] = (wchar_t) w[i];
	}
}
void invertIntString(int *array, int len, int i){
	if(i < (len/2)){
		int tmp = array[i];
		array[i] = array[len - i - 1];
		array[len - i - 1] = tmp;
		invertIntString(array,len,++i);
	}
}
int my_wcscmp(wchar_t *w1, wchar_t *w2){
	int wlen1 = wslen(w1),
		wlen2 = wslen(w2),
		minLen = (wlen1 < wlen2) ? wlen1 : wlen2,
		resp = 0;

	for(int i = 0; i < minLen; i++){
		if(w1[i] < w2[i]){
			resp = -1;
			i = minLen;
		}else if(w1[i] > w2[i]){
			resp = 1;
			i = minLen;
		}
	}
	if(resp == 0 && wlen1 != wlen2){
		resp = (wlen1 < wlen2) ? -1 : 1;
	}
	return resp;
}
int main(){
	setlocale(LC_ALL,"pt_BR.UTF-8");
	wchar_t *w = (wchar_t *)malloc(256*sizeof(wchar_t));
	readLine(w);
	while(my_wcscmp(w,L"FIM") != 0){
		int len = wslen(w);
		int *wInt = (int *)malloc(wslen(w) * sizeof(int));
		convertToInt(wInt, len, w);
		invertIntString(wInt,len,0);
		convertToWchar(w,len,wInt);
		wprintf(L"%ls\n",w);
		free(wInt);
		readLine(w);
	}
	free(w);
}
