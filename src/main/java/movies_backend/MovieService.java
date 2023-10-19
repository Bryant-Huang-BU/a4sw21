package movies_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository mR;

    public Movie addMovie(String title, String genres, String movieYear, String rottenTomatoesScore, String leadStudio) {
        Movie m = new Movie(title, genres, movieYear, rottenTomatoesScore, leadStudio);
        return mR.save(m);
    }

    public Movie addMovie1(long id, String title, String genres, String movieYear, String rottenTomatoesScore, String leadStudio) {
        Movie m = new Movie(title, genres, movieYear, rottenTomatoesScore, leadStudio);
        return mR.save(m);
    }
    public List<DTO> getAll() {
        List<Movie> m = mR.findAll();
        List<DTO> d = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            d.add(new DTO(m.get(i)));
        }
        return d;
    }

    public DTO updateScore(String title, String score) {
        Movie m = mR.findFirstByTitle(title);
        m.setScore(score);
        DTO d =  new DTO (m);
        return d;
    }

    public List<Movie> topMovies() {
        //mR.findBy'
        return mR.findAll();
    }
}
