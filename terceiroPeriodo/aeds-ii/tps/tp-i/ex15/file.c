#include <stdio.h>
#include <stdlib.h>

int main(){

	// char filePath[256] = "/home/cinema/faculdade/cc-puc-minas/terceiroPeriodo/aeds-ii/tps/tp-i/ex15/arquivo.txt";
	FILE *file = fopen("arquivo.txt","wb");
	float number;
	int quantidade;
	scanf("%d",&quantidade);
	for(int i = 0; i < quantidade; i++){
		scanf("%f",&number);
		fwrite(&number,sizeof(float),1,file);
	}
	fclose(file);
	file = fopen(filePath,"rb");
	for(int i = quantidade - 1; i >= 0; i--){
		float numberR;
		fseek(file,sizeof(float) * i,SEEK_SET);
		fread(&numberR,sizeof(float),1,file);
		printf("%g\n",numberR);
	}
	fclose(file);


	return 0;
}
