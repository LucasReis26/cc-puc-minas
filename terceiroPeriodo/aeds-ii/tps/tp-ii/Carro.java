public class Carro{
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("Ola mundo");
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

		String string = new String(sb);
		String bonito = new String("bonito");

		for(int i = 0; i < string.length(); i++){
			System.out.println(sb.charAt(i));
		}

		System.out.println(string + ' ' + bonito);
		Integer wordLen = string.length();
		System.out.println(wordLen);
	}
}
