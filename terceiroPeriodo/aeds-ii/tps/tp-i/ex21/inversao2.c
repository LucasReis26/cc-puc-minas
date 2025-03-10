#include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#include <locale.h>

size_t my_strlen(char *w){
	size_t count = 0;
	while(w[count] != '\0')
		count++;
	return count;
}

void readLine(char *w){
	fgets(w,256,stdin);
	size_t len = my_strlen(w);
	if(len > 0 && w[len - 1] == '\n')
		w[--len] = '\0';
}

int my_strcmp(char *w1, char *w2){
	size_t len1 = my_strlen(w1),
		   len2 = my_strlen(w2);

	int minValue = (len1 < len2) ? len1 : len2,
		resp = 0;
				
	for(int i = 0; i < minValue; i++){
		if(w1[i] < w2[i]){
			resp = -1;
			i = minValue;
		}else if(w1[i] > w2[i]){
			resp = 1;
			i = minValue;
		}
	}

	if(resp == 0 && len1 != len2){
		resp = (len1 < len2) ? -1 : 1;
	}

	return resp;
}

void convertToInt(int *line_int,wchar_t *utf_line,size_t len){
	for(int i = 0; i < len; i++){
		line_int[i] = (int) utf_line[i];
	}
}
void convertToWchar(wchar_t *utf_line,int *line_int,size_t len){
	for(int i = 0; i < len; i++){
		utf_line[i] = (wchar_t) line_int[i];
	}
}

void invertIntArray(int *array, int i, size_t len){
	if(i < (len/2)){
		int tmp = array[i];
		array[i] = array[len - i - 1];
		array[len - i - 1] = tmp;
		invertIntArray(array, ++i, len);
	}
}
void invertWChar(wchar_t *array, int i, size_t len){
	if(i < (len/2)){
		wchar_t tmp = array[i];
		array[i] = array[len - i - 1];
		array[len - i - 1] = tmp;
		invertWChar(array, ++i, len);
	}
}
int main(){
	// setlocale(LC_ALL,"");

	char *line = (char *)malloc(256*sizeof(char));

	readLine(line);

	while(my_strcmp(line,"FIM") != 0){
		size_t wlen = mbstowcs(NULL,line,0);

		wchar_t *utf_line = (wchar_t *)malloc((wlen + 1) * sizeof(wchar_t));
		// int *line_int = (int *)malloc((wlen + 1) * sizeof(int));
		mbstowcs(utf_line, line, wlen + 1);
		invertWChar(utf_line,0,wlen);
		// convertToInt(line_int, utf_line, wlen + 1);
		// invertIntArray(line_int, 0, wlen + 1);
		// convertToWchar(utf_line, line_int, wlen + 1);
		wcstombs(line,utf_line,256);

		// wprintf(L"%ls\n",utf_line);
		printf("%s\n",line);
		free(utf_line);

		readLine(line);
	}
	// free(line_int);
	free(line);
	return 0;
}
