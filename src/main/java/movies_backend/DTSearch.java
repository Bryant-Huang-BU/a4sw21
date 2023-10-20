package movies_backend;


public class DTSearch {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRottenTomatoesScore() {
        return rottenTomatoesScore;
    }

    public void setRottenTomatoesScore(int rottenTomatoesScore) {
        this.rottenTomatoesScore = rottenTomatoesScore;
    }

    int rottenTomatoesScore;
    public DTSearch(Movie m) {
        this.rottenTomatoesScore = m.getRottenTomatoesScore();
        this.title = m.getTitle();
    }

    // getters and setters
}

