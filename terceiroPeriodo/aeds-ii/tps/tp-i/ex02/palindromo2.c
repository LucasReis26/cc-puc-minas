#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <wchar.h>
#include <locale.h> // Para configurar a localização e suporte a caracteres wide

// Função para calcular o comprimento de uma string wide
int sLength(char *word) {
    int count = 0;
    while (word[count] != '\0')
        count++;
    return count;
}

// Função para comparar duas strings wide
int compareS(char *word1, char *word2) {
    int len1 = sLength(word1);
    int len2 = sLength(word2);
    int minorS = (len1 < len2) ? len1 : len2;

    for (int i = 0; i < minorS; i++) {
		if (word1[i] != word2[i]) {
            return (word1[i] > word2[i]) ? 1 : -1;
        }
    }

    if (len1 != len2) {
        return (len1 > len2) ? 1 : -1;
    }

    return 0; // As strings são iguais
}

// Função para remover o caractere de nova linha (\n) de uma string wide
void removeE(char *word) {
    int wlength = sLength(word);
    for (int i = 0; i < wlength; i++) {
        if (word[i] == '\n') {
            word[i] = '\0';
			i = wlength;
        }
    }
}

// Função para ler uma string wide da entrada
bool readS(char *word) {
    if (fgets(word, 255, stdin) == NULL) {
        return false; // Indica que o fim do arquivo foi atingido
    }
    removeE(word);
    return true; // Indica que a leitura foi bem-sucedida
}

// Função para inverter uma string wide
void inverseString(char *word, char *iString) {
    int wlength = sLength(word);

    for (int i = 0; i < wlength; i++) {
        iString[i] = word[wlength - 1 - i];
    }

    iString[wlength] = '\0';
}

// Função para verificar se uma string wide é um palíndromo
bool ehPalindromo(char *word) {
    char iString[255];
    inverseString(word, iString);
    return compareS(word, iString) == 0; // Retorna true se for um palíndromo
}

int main() {
    setlocale(LC_ALL, "en_US.UTF-8"); // Configura a localização para suportar caracteres wide
    char word[255];

    while (readS(word)) { // Lê a próxima palavra
        if (compareS(word, "FIM") == 0) {
            break; // Sai do loop se a palavra for "FIM"
        }

        if (ehPalindromo(word)) { // Verifica se é um palíndromo
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
