<h1 align="center"> Explicação do Quadro de Medalhas </h1>

## Exemplo de código com defeito

```
import java.util.*;

// A ordem dos países no quadro de medalhas é dada pelo número de medalhas de ouro. Se há empate em medalhas de ouro, a nação que tiver mais medalhas de prata fica a frente. Havendo empate em medalhas de ouro e prata, fica mais bem colocado o país com mais medalhas de bronze. Se dois ou mais países empatarem nos três tipos de medalhas, seu programa deve mostrá-los em ordem alfabética.

class Medals{
    String nome;
    int ouro;
    int prata;
    int bronze;
    
    public Medals(String nome, int ouro, int prata, int bronze){
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
    void printabosta(){
        System.out.println(this.nome +" "+ this.ouro +" "+ this.prata +" "+ this.bronze);
    }
}


class Medalhas{
    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int controle = sc.nextInt(); 
        Medals[] paises = new Medals[controle]; 
        
            for (int i = 0; i < controle; i++) {
                String nome = sc.next(); 
                int ouro = sc.nextInt();
                int prata = sc.nextInt();
                int bronze = sc.nextInt();
                paises[i] = new Medals(nome, ouro, prata, bronze); 
            }
            
            for(int i = 0; i < paises.length - 1; i++){
                for(int j = 0; j < paises.length - i - 1; j++){
                    if(paises[j+1].ouro > paises[j].ouro){
                        Medals aux = paises[j];
                        paises[j] = paises[j+1];
                        paises[j+1] = aux;
                    } else if(paises[j+1].prata > paises[j].prata){
                        Medals aux = paises[j];
                        paises[j] = paises[j+1];
                        paises[j+1] = aux;
                    } else if(paises[j+1].bronze > paises[j].bronze){
                        Medals aux = paises[j];
                        paises[j] = paises[j+1];
                        paises[j+1] = aux;
                    } else if(paises[j+1].ouro == paises[j].ouro && paises[j+1].prata == paises[j].prata && paises[j+1].bronze == paises[j].bronze && paises[j+1].nome.compareTo(paises[j].nome) < 0){
                      Medals aux = paises[j];
                      paises[j] = paises[j+1];
                      paises[j+1] = aux;
                  } 
                    
                }
            }
            sc.close();
            for(int i = 0; i < paises.length; i++){
             paises[i].printabosta();
            }
    }
}
```

## Parte com problema

```


for(int i = 0; i < paises.length - 1; i++){
    for(int j = 0; j < paises.length - i - 1; j++){
        if(paises[j+1].ouro > paises[j].ouro){
            Medals aux = paises[j];
            paises[j] = paises[j+1];
            paises[j+1] = aux;
        } else if(paises[j+1].prata > paises[j].prata){
            Medals aux = paises[j];
            paises[j] = paises[j+1];
            paises[j+1] = aux;
        } else if(paises[j+1].bronze > paises[j].bronze){
            Medals aux = paises[j];
            paises[j] = paises[j+1];
            paises[j+1] = aux;
        } else if(paises[j+1].ouro == paises[j].ouro && paises[j+1].prata == paises[j].prata && paises[j+1].bronze == paises[j].bronze && paises[j+1].nome.compareTo(paises[j].nome) < 0){
            Medals aux = paises[j];
            paises[j] = paises[j+1];
            paises[j+1] = aux;
        } 

    }
}

```

### Por que não funciona?

A ordenação acima não funciona por conta de um sistema de hierarquia no exercício.

### Como o exercício está funcionando atualmente?

**Vamos supor dois países:**

PaísA 10 5 3

PaísB 8 6 100

**Primeiro caso teste**

```
paises[j + 1].ouro > paises[j].ouro => (FALSO)
```
**Segundo caso teste**
```
paises[j + 1].prata > paises[j].prata => (VERDADEIRO) (troca!)
```
**Resultado Errado**

PaísB 8 6 100

PaísA 10 5 3

**Problemática**

Se o PaísB não tiver **PELO MENOS** a mesma quantidade de medalhas de ouro, a verificação **NÃO** deveria continuar, pois isso dá a chance do PaísB trocar com o A por ter mais medalhas de prata. 

## Como corrigir?

Pra corrigir esse problema nós precisamos **garantir** que o paísB tenha pelo menos a mesma quantidade de medalhas que o PaísA, pra fazer isso vamos aninhar os _if() else()_.

### Trecho corrigido 

```
for(int i = 0; i < paises.length - 1; i++){
    for(int j = 0; j < paises.length - i - 1; j++){

        //Compara a quantidade de Ouros;
        if(paises[j+1].ouro > paises[j].ouro){

            Medals aux = paises[j];
            paises[j] = paises[j+1];
            paises[j+1] = aux;

        //Compara se a quantidade de Ouros são iguais;
        } else if(paises[j + 1].ouro == paises[j].ouro){
            
            //Se ouros forem IGUAIS compara prata;
            if(paises[j+1].prata > paises[j].prata){

                Medals aux = paises[j];
                paises[j] = paises[j+1];
                paises[j+1] = aux;

            //Compara se a quantidade de pratas são iguais;
            }else if(paises[j + 1].prata == paises[j].prata){

                //Se pratas forem IGUAIS compara bronze;
                if(paises[j+1].bronze > paises[j].bronze){

                    Medals aux = paises[j];
                    paises[j] = paises[j+1];
                    paises[j+1] = aux;

                //Compara se a quantidade de bronzes são iguais;
                }else if(paises[j+1].bronze == paises[j].bronze){

                    //Se bronzes forem IGUAIS compara nome;
                    if(paises[j+1].nome.compareTo(paises[j].nome) < 0){
                        Medals aux = paises[j];
                        paises[j] = paises[j+1];
                        paises[j+1] = aux;
                    }
                }
            }
        } 
    }
}
```
### Qual a diferença desse novo trecho pro antigo?

A diferença é que agora como os _if() else()_ estão aninhados e com verificações específicas pra garantir que as medalhas sejam iguais antes de passar para a próxima verificação, nunca mais o caso de exemplo que eu dei lá em cima irá ocorrer.

