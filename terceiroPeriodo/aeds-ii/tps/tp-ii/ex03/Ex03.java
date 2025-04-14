package ex03;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.io.IOException;
import java.io.RandomAccessFile;

class Show {
	private String show_id;
	private String type;
	private String title;
	private String director;
	private String[] cast;
	private String country;
	private LocalDate date_added;
	private Integer release_year;
	private String rating;
	private String duration;
	private String[] listed_in;

	public Show() {
		this.show_id = "";
		this.type = "";
		this.title = "";
		this.director = "";
		this.cast = new String[1];
		this.country = "";
		this.date_added = LocalDate.now();
		this.release_year = 0;
		this.rating = "";
		this.duration = "";
		this.listed_in = new String[1];
	}

	public Show(String show_id, String type, String title, String director, String[] cast, String country,
			LocalDate date_added, Integer release_year, String rating, String duration, String[] listed_in) {
		this.show_id = show_id;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date_added = date_added;
		this.release_year = release_year;
		this.rating = rating;
		this.duration = duration;
		this.listed_in = listed_in;
	}

	public void setShow_id(String show_id) {
		this.show_id = show_id;
	}

	public String getShow_id() {
		return show_id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return this.director;
	}

	public void setCast(String[] cast) {
		int len = cast.length;
		for(int i = 0; i < len - 1; i++){
			for(int j = 0; j < len - i - 1; j++){
				String atual = cast[j];
				String prox = cast[j + 1];

				if(atual.compareTo(prox) > 0){
					String aux = cast[j];
					cast[j] = cast[j + 1];
					cast[j + 1] = aux;
				}
			}
		}
		this.cast = cast;
	}

	public String[] getCast() {
		return this.cast;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setDateAdded(LocalDate date_added) {
		this.date_added = date_added;
	}

	public LocalDate getDateAdded() {
		return this.date_added;
	}

	public void setReleaseYear(Integer release_year) {
		this.release_year = release_year;
	}

	public Integer getReleaseYear() {
		return this.release_year;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRating() {
		return this.rating;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setListedIn(String[] listed_in) {
		this.listed_in = listed_in;
	}

	public String[] getListedIn() {
		return this.listed_in;
	}

	public String castToString(){
		Integer quantidade = this.cast.length;

		StringBuilder sb = new StringBuilder();

		for(int i = 0, k = 0; i < quantidade; i++){
			Integer wordLen = this.cast[i].length();
			sb.append(this.cast[i]);
			if(i != quantidade - 1){
				sb.append(", ");
			}
		}

		return new String(sb);
	}
	public String listed_inToString(){
		Integer quantidade = this.listed_in.length;
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0, k = 0; i < quantidade; i++){
			Integer wordLen = this.listed_in[i].length();
			sb.append(this.listed_in[i]);
			if(i != quantidade - 1){
				sb.append(", ");
			}
		}

		return new String(sb);
	}

	public void imprimir() {
		String data = "NaN";
		if(this.date_added != null){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
			data = date_added.format(formatter);
		}
		System.out.println("=> " + show_id + " ## " + title + " ## " + type + " ## " + director 
			+ " ## [" + castToString() +"] ## " + country + " ## " + data + " ## " + release_year 
			+ " ## " + rating + " ## " + duration + " ## [" + listed_inToString() +"] ##");
	}

	public void ler(String line) {
		Integer len = line.length();
		String[] splittedWords = new String[11];
		StringBuilder sb = new StringBuilder();
		for(int i = 0, k = 0, l = 0; i < len && k < 11; i++){
			if(line.charAt(i) != ','){
				if(line.charAt(i) == '"'){
					i++;
					while(line.charAt(i) != '"'){
						sb.append(line.charAt(i++));
					}
				}else{
					sb.append(line.charAt(i));
				}
				
			}else if(line.charAt(i) == ',' && line.charAt(i + 1) == ','){
				splittedWords[k] = new String(sb);
				sb = new StringBuilder();
				k++;
				l = 0;
				sb.append("NaN");
				splittedWords[k] = new String(sb);

			}else if(line.charAt(i) == ',' && line.charAt(i + 1) != ','){
				splittedWords[k] = new String(sb);
				sb = new StringBuilder();
				k++;
				l = 0;
			}
		}

		String l_show_id = "";
		String l_type = "";
		String l_title = "";
		String l_director = "";
		String[] l_cast = new String[1];
		String l_country = "";
		LocalDate l_date_added = LocalDate.now();
		Integer l_release_year = 0;
		String l_rating = "";
		String l_duration = "";
		String[] l_listed_in = new String[1];


		for(int i = 0; i < 11; i++){
			switch(i){
				case 0:
					l_show_id = new String(splittedWords[i]);
					setShow_id(l_show_id);
					break;
				case 1:
					l_type = new String(splittedWords[i]);
					setType(l_type);
					break;
				case 2:
					l_title = new String(splittedWords[i]);
					setTitle(l_title);
					break;
				case 3:
					l_director = new String(splittedWords[i]);
					setDirector(l_director);
					break;
				case 4:
					Integer countCast = 1;
					Integer castLen = splittedWords[i].length();

					for(int j = 0; j < castLen; j++){
						if(splittedWords[i].charAt(j) == ',')
							countCast++;
					}

					l_cast = new String[countCast];
					
					sb = new StringBuilder();
					for(int j = 0, k = 0; j < castLen; j++){
						if(splittedWords[i].charAt(j) != ','){
							sb.append(splittedWords[i].charAt(j));
						}else if(splittedWords[i].charAt(j) == ','){
							j++;
							l_cast[k] = new String(sb);
							k++;
							sb = new StringBuilder();
						}
						if(j == castLen - 1){
							j++;
							l_cast[k] = new String(sb);
							k++;
							sb = new StringBuilder();
						}
					}

					setCast(l_cast);
					break;
				case 5:
					l_country = new String(splittedWords[i]);
					setCountry(l_country);
					break;
				case 6:
					if(!splittedWords[i].equals("NaN")){
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
						l_date_added = LocalDate.parse(splittedWords[i],formatter);
						setDateAdded(l_date_added);
					}else{
						setDateAdded(null);
					}
					break;
				case 7:
					l_release_year = Integer.parseInt(splittedWords[i]);
					setReleaseYear(l_release_year);
					break;
				case 8:
					l_rating = new String(splittedWords[i]);
					setRating(l_rating);
					break;
				case 9:
					l_duration = new String(splittedWords[i]);
					setDuration(l_duration);
					break;
				case 10:
					Integer countListed_in = 1;
					Integer listedLen = splittedWords[i].length();

					for(int j = 0; j < listedLen; j++){
						if(splittedWords[i].charAt(j) == ',')
							countListed_in++;
					}

					l_listed_in = new String[countListed_in];
					
					sb = new StringBuilder();
					for(int j = 0, k = 0; j < listedLen; j++){
						if(splittedWords[i].charAt(j) != ','){
							sb.append(splittedWords[i].charAt(j));
						}else if(splittedWords[i].charAt(j) == ','){
							j++;
							l_listed_in[k] = new String(sb);
							k++;
							sb = new StringBuilder();
						}
						if(j == listedLen - 1){
							j++;
							l_listed_in[k] = new String(sb);
							k++;
							sb = new StringBuilder();
						}
					}

					setListedIn(l_listed_in);
					break;
			}
		}
	}

	public Show clone(){
		Show clone = new Show(this.show_id, this.type, this.title, this.director, this.cast, this.country, this.date_added, this.release_year, this.rating, this.duration, this.listed_in);
		return clone;
	}
}

public class Ex03{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		File arquivo = new File("/tmp/disneyplus.csv");
		Scanner filesc = new Scanner(arquivo,"UTF-8");
		filesc.nextLine();

		Show[] shows = new Show[1368];

		for(int i = 0; i < 1368; i++){
			String line = filesc.nextLine();
			shows[i] = new Show();
			shows[i].ler(line);
		}
		filesc.close();

		Show[] array = new Show[1368];

		String getId = sc.nextLine();
		Integer tam_array = 0;
		while(!getId.equals("FIM")){
			Integer id = Integer.parseInt(getId.substring(1,getId.length()));
			array[tam_array++] = shows[id - 1].clone();
			getId = sc.nextLine();
		}

		arquivo = new File("./ex03/853431_sequencial.txt");
		Integer comparacoes = 0;
		long inicio = System.nanoTime();

		String line = sc.nextLine();
		while(!line.equals("FIM")){
			Boolean found = false;
			for(int i = 0; i < tam_array; i++){
				comparacoes++;
				if(array[i].getTitle().equals(line)){
					found = true;
				}
			}
			if(found)
				System.out.println("SIM");
			else
				System.out.println("NAO");
			line = sc.nextLine();
		}

		long fim = System.nanoTime();

		long duracao = fim - inicio;
		try{
			FileWriter fw = new FileWriter(arquivo);
			fw.write("853431\t" + (duracao / 1_000_000.0) + "ms\t" + comparacoes);
			fw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		sc.close();
	}
}
