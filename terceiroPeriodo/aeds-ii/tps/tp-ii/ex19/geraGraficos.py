import matplotlib

matplotlib.use('Agg')

import matplotlib.pyplot as plt

labels = ['100', '1000', '10000', '100000']
valores = [0, 5, 65, 4439]

plt.bar(labels, valores)
plt.title('Tempo(ms) Inserção')
plt.savefig("tempo_insercao.png")

