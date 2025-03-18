#include <stdio.h>
#include <stdlib.h>

void preencheMarmore(int *array, int len){
	for(int i = 0; i < len; i++){
		scanf("%d",&array[i]);
	}
	for(int i = 0; i < len - 1; i++){
		int swapped = 0;
		for(int j = 0; j < len -i -1; j++){
			if(array[j] > array[j + 1]){
				int tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
				swapped = 1;
			}
		}
		if(!swapped)
			i = len;
	}
}
void preencheConsultas(int *array, int len){
	for(int i = 0; i < len; i++){
		scanf("%d",&array[i]);
	}
}
void procuraNumero(int *marmore, int *consulta, int m_len, int c_len){
	for(int i = 0; i < c_len; i++){
		for(int j = 0; j < m_len; j++){
			if(marmore[j] == consulta[i]){
				printf("%d found at %d\n",consulta[i],j + 1);
				j = m_len; //Stop Looping
			}else if(j == (m_len - 1)){
				printf("%d not found\n",consulta[i]);
			}
		}
	}
}
int main(){

	int q_marmore,
		consultas,
		i = 1;

	scanf("%d %d",&q_marmore,&consultas);

	while(q_marmore != 0 && consultas != 0){
		printf("CASE# %d:\n",i++);

		int *n_marmore = (int *)malloc(q_marmore * sizeof(int));
		int *n_consulta = (int *)malloc(consultas * sizeof(int));

		preencheMarmore(n_marmore,q_marmore);
		preencheConsultas(n_consulta,consultas);
		procuraNumero(n_marmore,n_consulta,q_marmore,consultas);

		free(n_marmore);
		free(n_consulta);
		scanf("%d %d",&q_marmore,&consultas);
	}

	return 0;
}
