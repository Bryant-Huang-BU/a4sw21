package movies_backend;

import lombok.Getter;

public class DTO {

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public void setGetRottenTomatoesScore(int getRottenTomatoesScore) {
        this.getRottenTomatoesScore = getRottenTomatoesScore;
    }

    public String getLeadStudio() {
        return leadStudio;
    }

    public void setLeadStudio(String leadStudio) {
        this.leadStudio = leadStudio;
    }

    @Getter
    String title;
    @Getter
    String genres;
    @Getter
    int movieYear;

    public String getTitle() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public int getGetRottenTomatoesScore() {
        return getRottenTomatoesScore;
    }

    @Getter
    int getRottenTomatoesScore;
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
