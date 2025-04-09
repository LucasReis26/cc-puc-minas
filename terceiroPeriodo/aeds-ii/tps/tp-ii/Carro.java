public class Carro{
	public static void main(String[] args){
		char[] word = new char[255];

		word[0] = 'O';
		word[1] = 'l';
		word[2] = 'a';
		word[3] = ' ';
		word[4] = 'm';
		word[5] = 'u';
		word[6] = 'n';
		word[7] = 'd';
		word[8] = 'o';

		String string = new String(word);
		String bonito = new String("bonito");

		System.out.println(string + ' ' + bonito);
	}
}
