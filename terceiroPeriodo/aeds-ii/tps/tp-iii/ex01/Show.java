package ex01;

import java.time.LocalDate;

public class Show{
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
		int len = listed_in.length;
		for(int i = 0; i < len - 1; i++){
			for(int j = 0; j < len - i - 1; j++){
				String atual = listed_in[j];
				String prox = listed_in[j + 1];

				if(atual.compareTo(prox) > 0){
					String aux = listed_in[j];
					listed_in[j] = listed_in[j + 1];
					listed_in[j + 1] = aux;
				}
			}
		}
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

	public LocalDate formatDate(String date){
		LocalDate resp;

		if(!date.equals("NaN")){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
			resp = LocalDate.parse(date,formatter);
		}else{
			date = "March 1, 1900";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
			resp = LocalDate.parse(date,formatter);
		}

		return resp;
	}

	public String[] splitAtributtes(String atributtes){
		String[] resp;

		Integer countListed_in = 1;
		Integer listedLen = atributtes.length();

		for(int j = 0; j < listedLen; j++){
			if(atributtes.charAt(j) == ',')
				countListed_in++;
		}

		resp = new String[countListed_in];

		StringBuilder sb = new StringBuilder();
		for(int j = 0, k = 0; j < listedLen; j++){
			if(atributtes.charAt(j) != ','){
				sb.append(splittedWords[i].charAt(j));
			}else if(atributtes.charAt(j) == ','){
				j++;
				resp[k] = new String(sb);
				k++;
				sb = new StringBuilder();
			}
			if(j == listedLen - 1){
				j++;
				resp[k] = new String(sb);
				k++;
				sb = new StringBuilder();
			}
		}
		return resp;
	}

	public String[] splitLine(String line){
		String[] resp = new String[11];

		Integer len = line.length();
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
				resp[k] = new String(sb);
				sb = new StringBuilder();
				k++;
				l = 0;
				sb.append("NaN");
				resp[k] = new String(sb);

			}else if(line.charAt(i) == ',' && line.charAt(i + 1) != ','){
				resp[k] = new String(sb);
				sb = new StringBuilder();
				k++;
				l = 0;
			}
		}

		return resp;
	}

	public void ler(String line) {
		String[] splittedWords = splitLine(line);

		String l_show_id = new String(splittedWords[0]);
		setShow_id(l_show_id);

		String l_type = new String(splittedWords[1]);
		setType(l_type);

		String l_title = new String(splittedWords[2]);
		setTitle(l_title);

		String l_director = new String(splittedWords[3]);
		setTitle(l_title);

		String[] l_cast = splitAtributtes(splittedWords[4]);
		setCast(l_cast);

		String l_country = new String(splittedWords[5]);
		setCountry(l_country);

		LocalDate l_date_added = formatDate(splittedWords[6]);
		setDateAdded(l_date_added);

		Integer l_release_year = Integer.parseInt(splittedWords[7]);
		setReleaseYear(l_release_year);

		String l_rating = new String(splittedWords[8]);
		setRating(l_rating);

		String l_duration = new String(splittedWords[9]);
		setDuration(l_duration);

		String[] l_listed_in = splitAtributtes(splittedWords[10]);
		setListedIn(l_listed_in);
	}

	public Show clone(){
		Show clone = new Show(this.show_id, this.type, this.title, this.director, this.cast, this.country, this.date_added, this.release_year, this.rating, this.duration, this.listed_in);
		return clone;
	}
}
