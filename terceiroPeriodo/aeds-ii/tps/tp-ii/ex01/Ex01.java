package ex01;

import java.util.Scanner;
import java.util.Date;

class Show {
	private String show_id;
	private String type;
	private String title;
	private String director;
	private String[] cast;
	private String country;
	private Date date_added;
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
		this.date_added = new Date();
		this.release_year = 0;
		this.rating = "";
		this.duration = "";
		this.listed_in = new String[1];
	}

	public Show(String show_id, String type, String title, String director, String[] cast, String country,
			Date date_added, Integer release_year, String rating, String duration, String[] listed_in) {
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

	public void setDateAdded(Date date_added) {
		this.date_added = date_added;
	}

	public Date getDateAdded() {
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

		Integer len = 0;

		if(quantidade > 1){
			for(int i = 0; i < quantidade; i++){
				len += this.cast[i].length();
				if(i != quantidade - 1)
					len += 2;
			}
		}

		char[] resp = new char[len];

		for(int i = 0, k = 0; i < quantidade; i++){
			Integer wordLen = this.cast[i].length();
			for(int j = 0; j < wordLen; j++, k++){
				resp[k] = this.cast[i].charAt(j);
			}
			if(i != quantidade - 1){
				resp[k] = ','; 
				resp[k + 1] = ' '; 
				k += 2;
			}
		}

		return new String(resp);
	}
	public String listed_inToString(){
		Integer quantidade = this.listed_in.length;

		Integer len = 0;

		if(quantidade > 1){
			for(int i = 0; i < quantidade; i++){
				len += this.listed_in[i].length();
				if(i != quantidade - 1)
					len += 2;
			}
		}

		char[] resp = new char[len];

		for(int i = 0, k = 0; i < quantidade; i++){
			Integer wordLen = this.listed_in[i].length();
			for(int j = 0; j < wordLen; j++, k++){
				resp[k] = this.listed_in[i].charAt(j);
			}
			if(i != quantidade - 1){
				resp[k] = ','; 
				resp[k + 1] = ' '; 
				k += 2;
			}
		}

		return new String(resp);
	}

	public void imprimir() {
		System.out.println("=> " + show_id + " ## " + type + " ## " + title + " ## " + director 
			+ " ## [" + castToString() +"] ## " + country + " ## " + date_added + " ## " + release_year 
			+ " ## " + rating + " ## " + duration + " ## [" + listed_inToString() +"] ##");
	}

	public void ler(String line) {
		Integer len = line.length();
		char[][] splittedWords = new char[11][255];
		for(int i = 0, k = 0, l = 0; i < len && k < 11; i++){
			if(line.charAt(i) != ',' && line.charAt(i) != '"'){
				splittedWords[k][l++] = line.charAt(i);
				
			}else if(line.charAt(i) == ',' && line.charAt(i + 1) == ','){
				i++;
				k++;
				l = 0;
				splittedWords[k][l] = 'N';
				splittedWords[k][l + 1] = 'a';
				splittedWords[k][l + 2] = 'N';

			}else if(line.charAt(i) == ',' && line.charAt(i + 1) != ','){
				k++;
				l = 0;

			}else if(line.charAt(i) == ',' && line.charAt(i + 1) == '"'){
				k++;
				i+=2;
				l = 0;

				while(line.charAt(i) != '"'){
					splittedWords[k][l++] = line.charAt(i++);
				}
			}
		}
		for(int i = 0; i < 11; i++){
			System.out.println((i + 1) + " - " + new String(splittedWords[i]));
		}
	}
}

public class Ex01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		Show show = new Show();

		show.ler(line);

		sc.close();
	}
}
