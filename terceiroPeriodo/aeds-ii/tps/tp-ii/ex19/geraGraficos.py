import matplotlib

matplotlib.use('Agg')

import matplotlib.pyplot as plt

titulosAlgoritmos = ["Seleção", "Inserção", "Bubble","Quicksort"]
algoritmo = ['selecao', 'insercao', 'bubble', 'quicksort']
cores = ['blue', 'green', 'orange', 'red']
labels = ['100', '1000', '10000', '100000']
titulos = ["Comparações ", "Movimentações ", "Tempo(ms) "]
minititulos = ["comparacoes", "movimentacoes", "tempo"]

def geraGraficosGerais():
    for i in range(0,4,1):
        f1 = open('../'+ algoritmo[i] + '_array'+ labels[0] +'.txt')
        f2 = open('../'+ algoritmo[i] + '_array'+ labels[1] +'.txt')
        f3 = open('../'+ algoritmo[i] + '_array'+ labels[2] +'.txt')
        f4 = open('../'+ algoritmo[i] + '_array'+ labels[3] +'.txt')

        line1 = f1.readline()
        line2 = f2.readline()
        line3 = f3.readline()
        line4 = f4.readline()

        f1Content = line1.split()
        f2Content = line2.split()
        f3Content = line3.split()
        f4Content = line4.split()

        for j in range(0,3,1):
            valores = [int(f1Content[j]), int(f2Content[j]), int(f3Content[j]), int(f4Content[j])]

            plt.bar(labels, valores, color=cores[i])
            plt.yscale('log')
            plt.title(titulos[j] + titulosAlgoritmos[i])
            plt.savefig(minititulos[j] + '_' + algoritmo[i] +'.png')
            plt.clf()

        f1.close()
        f2.close()
        f3.close()
        f4.close()

def geraComparacoes():
    for i in range(0,4,1):
        f1 = open('../'+ algoritmo[0] + '_array'+ labels[i] +'.txt')
        f2 = open('../'+ algoritmo[1] + '_array'+ labels[i] +'.txt')
        f3 = open('../'+ algoritmo[2] + '_array'+ labels[i] +'.txt')
        f4 = open('../'+ algoritmo[3] + '_array'+ labels[i] +'.txt')

        line1 = f1.readline()
        line2 = f2.readline()
        line3 = f3.readline()
        line4 = f4.readline()

        f1Content = line1.split()
        f2Content = line2.split()
        f3Content = line3.split()
        f4Content = line4.split()

        for j in range(0,4,1):
            valores = [int(f1Content[0]),int(f2Content[0]),int(f3Content[0]),int(f4Content[0])]
            plt.bar(titulosAlgoritmos,valores,color=['blue','green','orange','red'])
            plt.yscale('linear')
            plt.title('Comparações Algoritmos ' + labels[i])
            plt.savefig('comparacoes_gerais' + labels[i] +'.png')
            plt.clf()

        f1.close()
        f2.close()
        f3.close()
        f4.close()

def geraMovimentacoes():
    for i in range(0,4,1):
        f1 = open('../'+ algoritmo[0] + '_array'+ labels[i] +'.txt')
        f2 = open('../'+ algoritmo[1] + '_array'+ labels[i] +'.txt')
        f3 = open('../'+ algoritmo[2] + '_array'+ labels[i] +'.txt')
        f4 = open('../'+ algoritmo[3] + '_array'+ labels[i] +'.txt')

        line1 = f1.readline()
        line2 = f2.readline()
        line3 = f3.readline()
        line4 = f4.readline()

        f1Content = line1.split()
        f2Content = line2.split()
        f3Content = line3.split()
        f4Content = line4.split()

        for j in range(0,4,1):
            valores = [int(f1Content[1]),int(f2Content[1]),int(f3Content[1]),int(f4Content[1])]
            plt.bar(titulosAlgoritmos,valores,color=['blue','green','orange','red'])
            plt.yscale('linear')
            plt.title('Movimentações Algoritmos ' + labels[i])
            plt.savefig('movimentacoes_gerais' + labels[i] +'.png')
            plt.clf()

        f1.close()
        f2.close()
        f3.close()
        f4.close()

def geraTempo():
    for i in range(0,4,1):
        f1 = open('../'+ algoritmo[0] + '_array'+ labels[i] +'.txt')
        f2 = open('../'+ algoritmo[1] + '_array'+ labels[i] +'.txt')
        f3 = open('../'+ algoritmo[2] + '_array'+ labels[i] +'.txt')
        f4 = open('../'+ algoritmo[3] + '_array'+ labels[i] +'.txt')

        line1 = f1.readline()
        line2 = f2.readline()
        line3 = f3.readline()
        line4 = f4.readline()

        f1Content = line1.split()
        f2Content = line2.split()
        f3Content = line3.split()
        f4Content = line4.split()

        for j in range(0,4,1):
            valores = [int(f1Content[2]),int(f2Content[2]),int(f3Content[2]),int(f4Content[2])]
            plt.bar(titulosAlgoritmos,valores,color=['blue','green','orange','red'])
            plt.yscale('linear')
            plt.title('Tempo(ms) Algoritmos ' + labels[i])
            plt.savefig('tempo_gerais' + labels[i] +'.png')
            plt.clf()

        f1.close()
        f2.close()
        f3.close()
        f4.close()



geraGraficosGerais()
geraComparacoes()
geraMovimentacoes()
geraTempo()


