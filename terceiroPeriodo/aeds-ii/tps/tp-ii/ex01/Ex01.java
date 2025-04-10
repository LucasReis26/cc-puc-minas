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
		
		System.out.println();
		System.out.println(quantidade);

		// Integer len = 0;
		//
		// if(quantidade > 1){
		// 	for(int i = 0; i < quantidade; i++){
		// 		len += this.listed_in[i].length();
		// 		if(i != quantidade - 1)
		// 			len += 2;
		// 	}
		// }
		//
		// char[] resp = new char[len];

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
		System.out.println("=> " + show_id + " ## " + type + " ## " + title + " ## " + director 
			+ " ## [" + castToString() +"] ## " + country + " ## " + date_added + " ## " + release_year 
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
		System.out.println();
		System.out.println("Detectado: ");
		for(int i = 0; i < 11; i++){
			System.out.println((i + 1) + " - " + splittedWords[i]);
		}

		String l_show_id = "";
		String l_type = "";
		String l_title = "";
		String l_director = "";
		String[] l_cast = new String[1];
		String l_country = "";
		Date l_date_added = new Date();
		Integer l_release_year = 0;
		String l_rating = "";
		String l_duration = "";
		String[] l_listed_in = new String[1];

		System.out.println();

		for(int i = 0; i < 11; i++){
			switch(i){
				case 0:
					l_show_id = new String(splittedWords[i]);
					setShow_id(l_show_id);
					System.out.println("SET SHOW ID " + l_show_id );
					break;
				case 1:
					l_type = new String(splittedWords[i]);
					setType(l_type);
					System.out.println("SET TYPE " + l_type);
					break;
				case 2:
					l_title = new String(splittedWords[i]);
					setTitle(l_title);
					System.out.println("SET TITLE " + l_title);
					break;
				case 3:
					l_director = new String(splittedWords[i]);
					setDirector(l_director);
					System.out.println("SET DIRECTOR " + l_director);
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
							System.out.println(l_cast[k]);
							k++;
							sb = new StringBuilder();
						}
						if(j == castLen - 1){
							j++;
							l_cast[k] = new String(sb);
							System.out.println(l_cast[k]);
							k++;
							sb = new StringBuilder();
						}
					}

					setCast(l_cast);
					System.out.println("SET CAST " + l_cast[0]);
					break;
				case 5:
					l_country = new String(splittedWords[i]);
					setCountry(l_country);
					System.out.println("SET COUNTRY " + l_country);
					break;
				case 6:
					l_date_added = new Date(splittedWords[i]);
					setDateAdded(l_date_added);
					System.out.println("SET DATE " + l_date_added);
					break;
				case 7:
					l_release_year = Integer.parseInt(splittedWords[i]);
					setReleaseYear(l_release_year);
					System.out.println("SET YEAR " + l_release_year);
					break;
				case 8:
					l_rating = new String(splittedWords[i]);
					setRating(l_rating);
					System.out.println("SET RATING " + l_rating);
					break;
				case 9:
					l_duration = new String(splittedWords[i]);
					setDuration(l_duration);
					System.out.println("SET DURATION " + l_duration);
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
							System.out.println(l_listed_in[k]);
							k++;
							sb = new StringBuilder();
						}
						if(j == listedLen - 1){
							j++;
							l_listed_in[k] = new String(sb);
							System.out.println(l_listed_in[k]);
							k++;
							sb = new StringBuilder();
						}
					}

					setListedIn(l_listed_in);
					System.out.println("SET LISTED " + l_listed_in[0]);
					break;
			}
		}
	}

	public Show clone(){
		Show clone = new Show(this.show_id, this.type, this.title, this.director, this.cast, this.country, this.date_added, this.release_year, this.rating, this.duration, this.listed_in);
		return clone;
	}
}

public class Ex01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		System.out.println();
		System.out.println("linha: " + line);
		System.out.println();

		Show show = new Show();

		show.ler(line);
		show.imprimir();

		sc.close();
	}
}
