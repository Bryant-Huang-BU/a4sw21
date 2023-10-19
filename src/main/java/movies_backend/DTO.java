package movies_backend;

public class DTO {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getGetRottenTomatoesScore() {
        return getRottenTomatoesScore;
    }

    public void setGetRottenTomatoesScore(String getRottenTomatoesScore) {
        this.getRottenTomatoesScore = getRottenTomatoesScore;
    }

    public String getLeadStudio() {
        return leadStudio;
    }

    public void setLeadStudio(String leadStudio) {
        this.leadStudio = leadStudio;
    }

    String title;
    String genres;
    String movieYear;
    String getRottenTomatoesScore;
    String leadStudio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    long id;
    public DTO(Movie m) {
        this.id = m.getId();
        this.title = m.getTitle();
        this.genres = m.getGenres();
        this.movieYear = m.getMovieYear();
        this.getRottenTomatoesScore = m.getRottenTomatoesScore();
        this.leadStudio = m.getLeadStudio();
    }

    // getters and setters
}
